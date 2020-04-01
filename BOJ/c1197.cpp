#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int V, E; //v: 정점 개수, e: 간선 개수

struct Node {
	int u, v, w;
};

bool operator<(const Node& a, const Node& b) {
	return a.w < b.w;
}

vector<Node> adj;

vector<int> parent;

int Find(int x) {
	if (x == parent[x]) return x;
	else {
		return parent[x] = Find(parent[x]);
	}
}

void Union(int x, int y) {
	x = Find(x);
	y = Find(y);
	if (x < y)	parent[y] = x;
	else		parent[x] = y;
}

int main() {
	scanf("%d%d", &V, &E);

	parent.resize(V + 1);
	for (int i = 1; i < parent.size(); i++) {
		parent[i] = i;
	}

	int a, b, c;
	for (int i = 0; i < E; i++) {
		scanf("%d%d%d", &a, &b, &c);
		adj.push_back({ a,b,c });
	}
	sort(adj.begin(), adj.end()); //오름차순 정렬

	int sum = 0, cnt = 0;
	for (Node& node : adj) {
		if (cnt == V - 1) break;
		if (Find(node.u) == Find(node.v)) continue;
		Union(node.u, node.v); cnt++; sum += node.w;
	}

	printf("%d", sum);

	return 0;
}