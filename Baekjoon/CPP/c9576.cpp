#include <iostream>
#include <vector>
#include <bitset>
#include <algorithm>
#include <cassert>

#define MAX 1000

using namespace std;

int Tcase, n, m;

bitset<MAX + 1> selled;
vector<pair<int, int> > v;
int ans;

bool cmp(const pair<int, int>& a, pair<int, int>& b) {
	if (a.second == b.second)
		return a.first < b.first;
	return a.second < b.second;
}

void init() {
	selled.reset();
	v.clear();
	ans = 0;
}

int main() {
	scanf("%d", &Tcase);
	for (int i = 0; i < Tcase; i++) {
		init();
		scanf("%d %d", &n, &m);
		int a, b;
		for (int i = 0; i < m; i++) {
			scanf("%d %d", &a, &b);
			v.push_back({ a,b });
		}
		sort(v.begin(), v.end(), cmp);

		for (int i = 0; i < v.size(); i++) {
			assert(v[i].first <= v[i].second);
			for (int j = v[i].first; j <= v[i].second; j++) {
				if (!selled[j]) {
					selled[j] = true;
					ans++;
					break;
				}
			}
		}
		printf("%d\n", ans);
	}

	return 0;
}