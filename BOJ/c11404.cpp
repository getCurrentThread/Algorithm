#include <iostream>
#include <vector>
#include <algorithm>

#define INF 987654321

using namespace std;

int n, m;
vector<vector<int> > map;

int main() {

	scanf("%d", &n);
	scanf("%d", &m);

	map.resize(n + 1);
	for (int i = 0; i <= n; i++) {
		map[i].resize(n + 1, INF);
	}
	for (int i = 1; i <= n; i++) {
		map[i][i] = 0;
	}

	int u, v, w;
	for (int i = 0; i < m; i++) {
		scanf("%d%d%d", &u, &v, &w);
		map[u][v] = min(map[u][v], w);
	}
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (map[i][j] == INF)	printf("0 ");
			else					printf("%d ", map[i][j]);
		}
		puts("");
	}

	return 0;
}