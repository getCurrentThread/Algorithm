#include <iostream>
#include <vector>
#include <queue>
#include <bitset>
#include <algorithm>

#define MAX 100

using namespace std;

int n, m;
int st, nd;

vector<vector<int> > v;
bitset<MAX + 1> visit;

int main() {
	
	scanf("%d", &n);
	scanf("%d", &m);

	v.resize(n + 1);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &st, &nd);
		v[st].push_back(nd);
		v[nd].push_back(st);
	}
	for (int i = 1; i < n + 1; i++) {
		sort(v[i].begin(), v[i].end());
		v[i].resize(unique(v[i].begin(), v[i].end()) - v[i].begin());
	}

	queue<int> q;
	int ans = -1;
	
	q.push(1);
	visit[1] = true;

	while (!q.empty()) {
		int e = q.front(); q.pop();
		ans++;
		for (int i = 0; i < v[e].size(); i++) {
			if (!visit[v[e][i]]) {
				q.push(v[e][i]);
				visit[v[e][i]] = true;
			}
		}
	}


	printf("%d", ans);


	return 0;
}