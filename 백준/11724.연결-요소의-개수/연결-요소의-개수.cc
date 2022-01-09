#include <iostream>
#include <set>

using namespace std;

int parent[1001] = { 0, };

int find(int a) {
	if (parent[a] == a) return a;
	return parent[a] = find(parent[a]);
}

void Union(int a, int b) {
	a = find(a);
	b = find(b);
	
	if(a != b)
		parent[a] = b;
}


int main() {
	cin.tie(0);

	int N, M;
	cin >> N >> M;

	for (int i = 0; i <= N; i++) {
		parent[i] = i;
	}

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		Union(a, b);
	}

	set<int> s;
	for (int i = 1; i <= N; i++) {
		s.insert(find(i));
	}

	cout << s.size() << endl;
	return 0;
}