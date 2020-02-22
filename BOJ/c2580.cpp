#include <iostream>
#include <vector>
#include <bitset>

using namespace std;

int board[9][9];

vector<pair<int, int> > lft;

bool solve(int deep) {
	bitset<10> bits;
	vector<int> psbl;
	pair<int, int> pos;

	if (lft.empty())
		return true;

	pos = lft.back();
	lft.pop_back();

	bits.reset();
	for (int i = 0; i < 9; i++) {
		bits.set(board[pos.first][i]);
		bits.set(board[i][pos.second]);
	}

	int m = (pos.first / 3) * 3;
	int n = (pos.second / 3) * 3;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			bits.set(board[m + i][n + j]);
		}
	}

	bits.flip();
	for (int i = 1; i <= 9; i++) {
		if (bits[i]) {
			psbl.push_back(i);
		}
	}

	for (int i = 0; i < psbl.size(); i++) {
		board[pos.first][pos.second] = psbl[i];
		if (solve(deep + i)) {
			return true;
		}
	}
	board[pos.first][pos.second] = 0;
	lft.push_back(pos);

	return false;
}


int main() {

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 0){
				lft.push_back({ i,j });
			}
		}
	}
	
	solve(0);

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			printf("%d ", board[i][j]);
		}
		printf("\n");
	}

	return 0;
}