#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 20

using namespace std;

int n;

int s[MAX][MAX];
int min_value = 12345678;

bool v[MAX];

void solve(int stack) {
	for (int i = stack; i < n; i++) {
		v[i] = true;
		if ((stack + 1) == (n / 2)) {
			int ans = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (v[i] && v[j]) {
						ans += s[i][j];
					}
					else if ((!v[i]) && (!v[j])) {
						ans -= s[i][j];
					}
				}
			}
			if (min_value > abs(ans)) {
				min_value = abs(ans);
			}
		}
		else{
			solve(stack + 1);
		}
		v[i] = false;
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