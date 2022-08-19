#include <iostream>
#include <vector>
#include <limits>


#define MAX 50

using namespace std;

int n, m;
int temp;

int s[13][100];
int ans = numeric_limits<int>::max();

vector<pair<int, int> > chicken;
vector<pair<int, int> > house;

vector<int>	sel;

void solve(int k) {
	for (int i = k; i < chicken.size(); i++) {
		sel.push_back(i);
		if (sel.size() == m) {
			temp = 0;
			for (int h = 0; h < house.size(); h++) {
				int r = numeric_limits<int>::max();
				for (int i = 0; i < sel.size(); i++) {
					if (r > s[sel[i]][h]) {
						r = s[sel[i]][h];
					}
				}
				temp += r;
			}

			if (ans > temp) {
				ans = temp;
			}
		}
		else {
			solve(i + 1);
		}
		sel.pop_back();
	}
}

int main() {
	
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &temp);
			switch (temp)
			{
			case 1:	house.push_back({ i,j });	break;
			case 2:	chicken.push_back({ i,j });	break;
			}
		}
	}

	for (int c = 0; c < chicken.size(); c++) {
		for (int h = 0; h < house.size(); h++) {
			s[c][h] = abs(chicken[c].first - house[h].first) + abs(chicken[c].second - house[h].second);
		}
	}

	solve(0);

	printf("%d", ans);

	return 0;
}