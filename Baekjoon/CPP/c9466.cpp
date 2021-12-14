#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int t, n, cnt;
vector<int> v;
vector<bool> visited;
vector<int> recur;

int tmp;

bool dfs(int i) {
	visited[i] = true;
	recur[i]++;
	if (visited[v[i]]) { // 방문하려는 노드가 이미 방문한 경우.
		return false;
	}
	if (recur[i] == 2) {
		
	}
}

int main() {
	scanf("%d", &t);

	for (int i = 0; i < t; i++) {
		scanf("%d", &n);

		v.resize(n + 1);
		visited.resize(n + 1);
		recur.resize(n + 1);

		cnt = 0;

		for (int i = 1; i < n + 1; i++) {
			scanf("%d", &tmp);
			v[i] = tmp;
			visited[i] = false; recur[i] = 0; //init
		}

		for (int i = 1; i < n + 1; i++)
		{
			if(visited[i] == false)
				dfs(i);
		}

		printf("%d\n", n - cnt);
	}

	return 0;
}