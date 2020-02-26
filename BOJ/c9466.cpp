#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int t;
int tmp;
vector<pair<int, int> > v;

int main() {
	scanf("%d", &t);

	for(int i = 0; i < t; i++){
		scanf("%d", &n);
		v.resize(n + 1);
		fill(v.begin(), v.end(), 0);
		for (int i = 0; i < n; i++) {
			scanf("%d", &tmp);
			v[i + 1] = { tmp, 0 };
		}

		for (int i = 1; i <= n; i++) {

		}
	}

	return 0;
}