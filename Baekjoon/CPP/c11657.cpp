#include <iostream>
#include <vector>
#include <algorithm>

#define INF 987654321

using namespace std;

struct Node {
	int u, v, w;
};

int N, M;
vector<Node> adj;
vector<int> dist;

int main() {
	scanf("%d%d", &N, &M);

	dist.resize(N + 1, INF); dist[1] = 0;

	int u, v, w;
	for (int i = 0; i < M; i++) {
		scanf("%d%d%d", &u, &v, &w);
		adj.push_back({ u, v, w });
	}

	for (int i = 0; i < N; i++) {
		for (auto& node : adj) {
			if (dist[node.u] == INF) continue;
			dist[node.v] = min(dist[node.v], dist[node.u] + node.w);
		}
	}

	for (auto& node : adj) {
		if (dist[node.u] == INF) continue;
		if (dist[node.v] > dist[node.u] + node.w) {
			printf("-1"); return 0;
		}
	}

	for (int i = 2; i < dist.size(); i++) {
		if (dist[i] == INF) printf("-1\n");
		else printf("%d\n", dist[i]);
	}

	return 0;
}
