#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define MAX 1000000

using namespace std;

typedef struct _product {
	int m, v;
}Jewel;

typedef struct _jewelAscValueCmp {
	bool operator()(const Jewel& a, const Jewel& b) {
		return a.v < b.v;
	}
}JewelAscValueCmp;

int n, k;
vector<Jewel> ju;
vector<int> ca;

priority_queue<Jewel, vector<Jewel>, JewelAscValueCmp> pq;



bool operator<(const Jewel& a, const Jewel& b) {
	return a.m < b.m;
}

int main() {
	scanf("%d %d", &n, &k);

	int m, v;
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &m, &v);
		ju.push_back({ m,v });
	}

	int c;
	for (int i = 0; i < k; i++) {
		scanf("%d", &c);
		ca.push_back(c);
	}

	sort(ju.begin(), ju.end());
	sort(ca.begin(), ca.end());
	
	long long ans = 0;
	int j = 0;
	for (int i = 0; i < ca.size(); i++) {
		int w = ca[i];
		for (; j < ju.size() && ju[j].m <= w; j++) {
			pq.push(ju[j]);
		}
		if (!pq.empty()) {
			Jewel jewel = pq.top(); pq.pop();
			ans += jewel.v;
		}
	}

	printf("%d", ans);

	return 0;
}