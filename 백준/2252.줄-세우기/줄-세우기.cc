#include <iostream>
#include <vector>
#include <queue>

#define INF 987654321

using namespace std;

int N, M;
vector<vector<int> > adj;
vector<int> cnt;
queue<int> q;
vector<int> ans;

int main() {
	scanf("%d%d", &N, &M);
	adj.resize(N + 1);
	cnt.resize(N + 1, 0);

	int u, v;
	for(int i = 0; i < M; i++) {
		scanf("%d%d", &u, &v);
		adj[u].push_back(v);
		cnt[v]++;
	}
	
	for (int i = 1; i < cnt.size(); i++) {
		if(cnt[i] == 0) q.push(i);
	}

	while (!q.empty()) {
		int x = q.front(); q.pop();
		for (int v : adj[x]) {
			if (--cnt[v] == 0) q.push(v);
		}
		ans.push_back(x);
	}

	for (int i = 0; i < ans.size(); i++) {
		printf("%d ", ans[i]);
	}
	
	return 0;
}