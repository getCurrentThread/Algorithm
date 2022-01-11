#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 25

using namespace std;

int a[MAX][MAX];
vector<int> v;
int cnt;

int posX[] = {-1, 0, 0, 1};
int posY[] = {0, -1, 1, 0};

void dfs(int x, int y) {
	a[x][y] = 0;
	v[cnt]++;

	for (int i = 0; i < 4; i++) {
		int mx = x + posX[i];
		int my = y + posY[i];
		if (0 > mx || MAX <= mx || 
			0 > my || MAX <= my || 
			a[mx][my] == 0) continue;

		dfs(mx, my);
	}
}

int main() {
	int n = 0;
	scanf("%d", &n); getchar();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			a[i][j] = getchar() - '0';
		}
		getchar();
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (a[i][j]){
				v.push_back(0);
				dfs(i, j);
				cnt++;
			}
		}
	}

	sort(v.begin(), v.end());

	printf("%d\n", cnt);
	for (int i = 0; i < v.size(); i++) {
		printf("%d\n", v[i]);
	}

	return 0;
}