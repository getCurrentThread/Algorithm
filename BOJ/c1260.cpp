#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int n, m, st;
int x, y;

vector<vector<int> > v;
vector<bool> visit;

void dfs(int pos) {
	visit[pos] = true;
	printf("%d ", pos);
	for (int i = 0; i < v[pos].size(); i++) {
		if (visit[v[pos][i]] == true) continue;
		dfs(v[pos][i]);
	}
}

void bfs(int pos) {
	queue<int> q;

	
	q.push(pos);
	visit[pos] = true;

	while (!q.empty())
	{
		pos = q.front(); q.pop();
		
		printf("%d ", pos);

		for (int i = 0; i < v[pos].size(); i++) {
			int nxt = v[pos][i];
			if (visit[nxt] == true) continue;
			q.push(nxt);
			visit[nxt] = true;
		}
	}
}

int main() {

	scanf("%d %d %d", &n, &m, &st);
	v.resize(n + 1);
	visit.resize(n + 1);
	

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	for (int i = 1; i < n + 1; i++) {
		sort(v[i].begin(), v[i].end());
		v[i].resize(unique(v[i].begin(), v[i].end()) - v[i].begin());
	}

	for (int i = 1; i < n + 1; i++) {
		visit[i] = false;
	}
	dfs(st);

	printf("\n");

	for (int i = 1; i < n + 1; i++) {
		visit[i] = false;
	}
	bfs(st);

	return 0;
}