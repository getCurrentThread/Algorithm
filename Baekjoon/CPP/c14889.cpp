#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

#define MAX 20

using namespace std;

int n;

int s[MAX][MAX];
int min_value = numeric_limits<int>::max();

vector<int> v;

void solve(int k) {
	for (int i = k; i < n; i++) {
		v.push_back(i);
		if (v.size() == (n / 2)) {
			int ans = 0;
			vector<int> r;

			for (int i = 0; i < n; i++) {
				if (find(v.begin(), v.end(), i) == v.end()) {
					r.push_back(i);
				}
			}
			for (int i = 0; i < v.size(); i++) {
				for (int j = i + 1; j < v.size(); j++) {
					ans += s[v[i]][v[j]];
				}
			}
			for (int i = 0; i < r.size(); i++) {
				for (int j = i + 1; j < r.size(); j++) {
					ans -= s[r[i]][r[j]];
				}
			}

			if (min_value > abs(ans)) {
				min_value = abs(ans);
			}
		}
		else {
			solve(i + 1);
		}
		v.pop_back();
	}
}


int main() {

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &s[i][j]);
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			s[i][j] += s[j][i];
		}
	}

	solve(0);

	printf("%d", min_value);

	return 0;
}