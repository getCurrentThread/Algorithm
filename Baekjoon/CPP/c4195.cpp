#include <iostream>
#include <map>

#define MAX 200000

using namespace std;

int parent[MAX + 1];
int siz[MAX + 1];

map<string, int> mp;
int cnt;

int Find(int x) {
	if (x == parent[x]) return x;
	else {
		return parent[x] = Find(parent[x]);
	}
}

int Union(int x, int y) {
	x = Find(x);
	y = Find(y);
	
	int sum = siz[x] + siz[y];
	//siz를 합한다. (단, 같은 집합에 이미 소속되어 있을 경우는 제외)
	if (x < y) {
		parent[y] = x;
		return siz[x] = siz[y] = sum;
	}
	else if (x > y) {
		parent[x] = y;
		return siz[x] = siz[y] = sum;
	}
	else return siz[x];
}

int merge(string x, string y) {
	if (mp.count(x) == 0) mp.insert({ x, cnt++ });
	if (mp.count(y) == 0) mp.insert({ y, cnt++ });
	return Union(mp[x], mp[y]);
}

int main() {
	int Tcase;
	scanf("%d", &Tcase);

	for (int i = 0; i < Tcase; i++) {
		int F;
		scanf("%d", &F);

		//init
		cnt = 0;
		mp.clear();
		for (int i = 0; i <= (F * 2); i++) {
			parent[i] = i;
			siz[i] = 1;
		}

		for (int i = 0; i < F; i++) {
			char personA[21], personB[21];
			scanf("%s %s", personA, personB);
			printf("%d\n", merge(personA, personB));
		}
	}


	return 0;
}