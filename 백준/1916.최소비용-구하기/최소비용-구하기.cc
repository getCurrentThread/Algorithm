#include <iostream>
#include <vector>
#include <queue>

#define INF 987654321

using namespace std;

vector<vector<pair<int, int> > > graph;
vector<int> dist;

struct cmp {
	bool operator()(pair<int, int> &a, pair<int, int> &b) {
		return a.second > b.second;
	}
};

priority_queue<pair<int, int>, vector<pair<int, int> >, cmp> pq;

int main() {
	int N, M;
	scanf("%d", &N); graph.resize(N + 1); dist.resize(N + 1, INF);
	scanf("%d", &M);

	int st, nd, w;
	for (int i = 0; i < M; i++) {
		scanf("%d%d%d", &st, &nd, &w);
		graph[st].push_back({ nd, w });
	}
	scanf("%d%d", &st, &nd); //출발 -> 도착

	dist[st] = 0;
	pq.push({ st, 0 });
	
	while (!pq.empty()) {
		int u = pq.top().first;
		int d = pq.top().second; pq.pop();
		if (d > dist[u]) continue;
		for (int i = 0; i < graph[u].size(); i++) {
			int v = graph[u][i].first;
			int w = graph[u][i].second;
			if (dist[v] > dist[u] + w) {
				dist[v] = dist[u] + w;
				pq.push({ v, dist[v] });
			}
		}
	}

	if (dist[nd] != INF) printf("%d", dist[nd]);
	else				 printf("INF");
	return 0;
}