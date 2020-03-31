#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define INF 987654

using namespace std;

int N, E;
vector<vector<pair<int, int> > > graph;

bool operator<(const pair<int, int>& a, const pair<int, int>& b) {
	return a.second > b.second;
}

int Dijkstra(const int st, const int nd) {
	priority_queue<pair<int, int> > pq;
	vector<int> dist(N + 1, INF);
	dist[st] = 0;
	pq.push({ st, 0 });
	
	while (!pq.empty()) {
		int u = pq.top().first;
		int d = pq.top().second; pq.pop();
		if (dist[u] < d) continue;
		for (int i = 0; i < graph[u].size(); i++) {
			int v = graph[u][i].first;
			int w = graph[u][i].second;
			if (dist[v] > dist[u] + w) {
				dist[v] = dist[u] + w;
				pq.push({ v, dist[v] });
			}
		}
	}

	return dist[nd];
}

int main() {
	scanf("%d%d", &N, &E);
	graph.resize(N + 1);

	int u, v, w;
	for (int i = 0; i < E; i++) {
		scanf("%d%d%d", &u, &v, &w);
		graph[u].push_back({ v, w });
		graph[v].push_back({ u, w });
	}
	
	int n1, n2;
	scanf("%d%d", &n1, &n2);

	// 1번 -> n1, n2 -> N번
	int mn = min(Dijkstra(1, n1) + Dijkstra(n2, N),
				 Dijkstra(1, n2) + Dijkstra(n1, N)) + Dijkstra(n1, n2);
	
	if (mn >= INF)	printf("-1");
	else			printf("%d", mn);

	return 0;
}