#include <iostream>

#define MAX 200

using namespace std;

int parent[MAX + 1];

int Find(int x) {
	if (x == parent[x]) return x;
	else return parent[x] = Find(parent[x]);
}

void Union(int x, int y){
	x = Find(x);
	y = Find(y);
	if (y < x) parent[x] = y;
	else parent[y] = x;
}

int main() {
	int n, m;
	scanf("%d", &n);
	scanf("%d", &m);

	for (int i = 0; i <= n; i++) {
		parent[i] = i;
	}

	int tmp;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%d", &tmp);
			if (tmp) Union(i, j);
		}
	}

	int grp;
	if (m != 0) { scanf("%d", &grp); grp = Find(grp); }

	for (int i = 1; i < m; i++) {
		scanf("%d", &tmp);
		if (grp != Find(tmp)) {
			printf("NO");
			return 0;
		}
	}

	printf("YES");
	return 0;
}