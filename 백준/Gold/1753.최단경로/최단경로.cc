#include <iostream>
#include <vector>
#include <queue>

#define INF 987654321
#define MAX 20000

using namespace std;

vector<vector<pair<int, int> > > graph;

struct cmp {
    bool operator()(pair<int, int>& a, pair<int, int>& b) {
        return a.second > b.second;
    }
};

int main() {
    int V, E, K; //v:정점개수, e:간선개수, k:시작정점
    scanf("%d%d", &V, &E);
    scanf("%d", &K);

    graph.resize(V + 1);

    int u, v, w; // u -> v 정점으로 가중치 w인 간선
    for (int i = 0; i < E; i++) {
        scanf("%d%d%d", &u, &v, &w);
        graph[u].push_back({ v, w });
    }

    priority_queue<pair<int, int>, vector<pair<int, int> >, cmp> pq;
    vector<int> dist(V + 1, INF);
    dist[K] = 0;

    pq.push({ K, 0 });

    while (!pq.empty()) {
        int u = pq.top().first;
        int d = pq.top().second;
        pq.pop();
        if (d > dist[u]) continue; //지금 기록된 것보다 비용이 크다면 버림.
        
        for (int i = 0; i < graph[u].size(); i++) {
            int v = graph[u][i].first;
            int w = graph[u][i].second;
            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w;
                pq.push({ v, dist[v] });
            }
        }
    }

    for (int i = 1; i <= V; i++) {
        if (dist[i] != INF) printf("%d\n", dist[i]);
        else printf("INF\n");
    }

    return 0;
}