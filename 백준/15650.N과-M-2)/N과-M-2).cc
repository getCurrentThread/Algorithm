#include <iostream>
#include <vector>

using namespace std;

int n, m;

int v[9];

void dfs(int deep, int i) {
	if (deep == m) {
		for (int i = 0; i < m; i++) {
			printf("%d ", v[i]);
		}
		puts("");
		return;
	}
	for (; i <= n; i++) {
		v[deep] = i;
		dfs(deep + 1, i + 1);
	}
}

int main() {
	scanf("%d %d", &n, &m);

	dfs(0, 1);

	return 0;
}