#include<iostream>

using namespace std;

int n, m;
int map[50][50];

int dx[] = { 1, 1, 1, 0, 0, -1, -1, -1 };
int dy[] = { 1, 0, -1, 1, -1, 1, 0, -1 };

void dfs(int x, int y) {
	map[x][y] = 0;
	for (int i = 0; i < 8; i++) {
		int cx = x + dx[i]; int cy = y + dy[i];
		if (0 <= cx && 0 <= cy && cx < n && cy < m && map[cx][cy])
			dfs(cx, cy);
	}
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);


	while (true) {
		int cnt = 0;
		cin >> m >> n;
		if (n == 0 && m == 0) break;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cin >> map[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}

	return 0;
}