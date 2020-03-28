#include <iostream>
#include <vector>

#define MAX 1000000

using namespace std;

int n, m;
int parent[MAX + 1];

int Find(int x) {
	if (x == parent[x]) {
		return x;
	}
	else {
		return parent[x] = Find(parent[x]);
	}
}

void Union(int x, int y) {
	x = Find(x);
	y = Find(y);
	parent[y] = x;
}

int main() {
	scanf("%d%d", &n, &m);

	for (int i = 0; i <= n; i++) {
		parent[i] = i;
	}

	int op, a, b;
	for (int i = 0; i < m; i++) {
		scanf("%d%d%d", &op, &a, &b);
		switch (op) {
		case 0:
			Union(a, b);
			break;
		case 1:
			if (Find(a) == Find(b)) printf("YES\n");
			else					printf("NO\n");
			break;
		}
	}

	return 0;
}