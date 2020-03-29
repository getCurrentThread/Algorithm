#include <iostream>

#define MAX 100000

using namespace std;

int parent[MAX + 1];

int Find(int x) {
	if (x == parent[x]) return --parent[x];
	else return parent[x] = Find(parent[x]);
}

int main() {
	int G, P;

	scanf("%d", &G);
	scanf("%d", &P);
	
	for (int i = 0; i <= G; i++) {
		parent[i] = i;
	}

	int cnt = 0;
	int tmp;
	for (int i = 0; i < P; i++) {
		scanf("%d", &tmp);
		if (Find(tmp) == -1) 
			break;
		cnt++;
	}
	printf("%d", cnt);

	return 0;
}