#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

#define INF 987654321

using namespace std;

vector<vector<pair<int, int> > > graph;
vector<int> dist;

vector<vector<pair<int, int> > > rev_graph;
vector<int> rev_dist;

bool operator<(const pair<int, int>& a, const pair<int, int>& b) {
	return a.second > b.second;
}

priority_queue<pair<int, int> > pq;

int main() {
	int N, M, X;
	scanf("%d%d%d", &N, &M, &X);
	
	graph.resize(N + 1);		rev_graph.resize(N + 1);
	dist.resize(N + 1, INF);	rev_dist.resize(N + 1, INF);

	int st, nd, w;
	for (int i = 0; i < M; i++) {
		scanf("%d%d%d", &st, &nd, &w);
		graph[st].push_back({ nd, w });
		rev_graph[nd].push_back({st, w});
	}

	dist[X] = rev_dist[X] = 0;
	pq.push({ X, 0 });

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

	pq.push({ X, 0 });

	while (!pq.empty()) {
		int u = pq.top().first;
		int d = pq.top().second; pq.pop();
		if (rev_dist[u] < d) continue;
		for (int i = 0; i < rev_graph[u].size(); i++) {
			int v = rev_graph[u][i].first;
			int w = rev_graph[u][i].second;
			if (rev_dist[v] > rev_dist[u] + w) {
				rev_dist[v] = rev_dist[u] + w;
				pq.push({ v, rev_dist[v] });
			}
		}
	}
	
	int mx = 0;
	for (int i = 1; i < dist.size(); i++) {
		mx = max(mx, dist[i] + rev_dist[i]);
	}


	printf("%d", mx);

	return 0;
}