#include <iostream>
#include <vector>

#define INF 987654321

using namespace std;

int N, M;
vector<vector<int> > adj;

int main() {
	scanf("%d", &N);
	scanf("%d", &M);

	adj.resize(N + 1);
	for (int i = 0; i < adj.size(); i++) {
		adj[i].resize(N + 1, INF);
	}

	for (int i = 1; i < adj.size(); i++) {
		adj[i][i] = 0;
	}

	int a, b;
	for (int i = 0; i < M; i++) {
		scanf("%d%d", &a, &b);
		adj[a][b] = 1;
		adj[b][a] = -1;
	}

	for (int k = 1; k <= N; k++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (adj[i][k] == 1 && adj[k][j] == 1)
					adj[i][j] = 1;
				else if (adj[i][k] == -1 && adj[k][j] == -1)
					adj[i][j] = -1;
			}
		}
	}

	for (int i = 1; i <= N; i++) {
		int sum = 0;
		for (int j = 1; j <= N; j++) {
			if (adj[i][j] == INF) sum++;
		}
		printf("%d\n", sum);
	}

	return 0;
}