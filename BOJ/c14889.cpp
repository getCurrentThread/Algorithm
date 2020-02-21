#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 20

using namespace std;

int n;

int s[MAX][MAX];
int min_value = 12345678;

vector<int> v;

void solve(int stack) {
	for (int i = stack; i < n; i++) {
		v.push_back(i);
		if (v.size() == (n / 2)) {
			int ans = 0;
			vector<int> r;
			for (int i = 0; i < n; i++) {
				if (find(v.begin(), v.end(), i) == v.end()) {
					r.push_back(i);
				}
			}
			for (vector<int>::iterator i = v.begin(); i != v.end(); i++) {
				for (vector<int>::iterator j = v.begin(); j != v.end(); j++) {
					ans += s[*i][*j];
				}
			}
			for (vector<int>::iterator i = r.begin(); i != r.end(); i++) {
				for (vector<int>::iterator j = r.begin(); j != r.end(); j++) {
					ans -= s[*i][*j];
				}
			}
			if (min_value > abs(ans)) {
				min_value = abs(ans);
			}
		}
		else{
			solve(stack + 1);
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

	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < i; j++) {
	//		s[i][j] += s[j][i];
	//	}
	//}
	solve(0);

	printf("%d", min_value);

	return 0;
}