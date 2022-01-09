#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;

int v[9];
int map[9];
bool chck[9];

void dfs(int deep) {
	if (deep == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", map[v[i]]);
		}
		puts("");
		return;
	}
	for (int i = 1; i <= n; i++) {
		if(!chck[i]){
			chck[i] = true;
			v[deep] = i;
			dfs(deep + 1);
			chck[i] = false;
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &map[i]);
	}
	sort(map+1, map+n+1);
	dfs(0);

	return 0;
}