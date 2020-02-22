#include <iostream>
#include <bitset>

using namespace std;

int board[9][9];

int lft;

void solve() {
	int ele;
	bitset<10> bits;
	pair<int, int> pos;

	while (lft) {
		for (int i = 0; i < 9; i++) { //가로
			bits.reset();
			for (int j = 0; j < 9; j++) {
				ele = board[i][j];
				bits.set(ele);
				
				if(ele == 0){
					pos = { i, j };
				}
			}
			if (bits[0] && bits.count() == 9) {
				bits.flip();
				for (int i = 1; i < 10; i++) {
					if (bits[i]) {
						board[pos.first][pos.second] = i;
						lft--;
						break;
					}
				}
			}
		}
		for (int i = 0; i < 9; i++) { //세로
			bits.reset();
			for (int j = 0; j < 9; j++) {
				ele = board[j][i];
				bits.set(ele);

				if (ele == 0) {
					pos = { j, i };
				}
			}
			if (bits[0] && bits.count() == 9) {
				bits.flip();
				for (int i = 1; i < 10; i++) {
					if (bits[i]) {
						board[pos.first][pos.second] = i;
						lft--;
						break;
					}
				}
			}
		}

		for (int n = 0; n < 3; n++) { //3 x 3
			for (int m = 0; m < 3; m++) { 
				bits.reset();
				for (int i = 0; i < 3; i++) { //3 x 3
					for (int j = 0; j < 3; j++) {
						ele = board[n*3+i][m*3+j];
						bits.set(ele);

						if (ele == 0) {
							pos = { n * 3 + i,m * 3 + j };
						}
					}
				}
				if (bits[0] && bits.count() == 9) {
					bits.flip();
					for (int i = 1; i < 10; i++) {
						if (bits[i]) {
							board[pos.first][pos.second] = i;
							lft--;
							break;
						}
					}
				}
			}
		}
	}
}


int main() {

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			scanf("%d", &board[i][j]);
			if (board[i][j] == 0){
				lft++;
			}
		}
	}
	
	solve();

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			printf("%d ", board[i][j]);
		}
		printf("\n");
	}

	return 0;
}