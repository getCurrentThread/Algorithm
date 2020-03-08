#include <iostream>
#include <algorithm>

#define MAX 1000

using namespace std;

int n;

int memo[MAX + 1];
int v[MAX];

int main() {

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &v[i]);
	}

	memo[0] = 0;
	for (int i = 0; i < n; i++) { //주체 i
		int mx = 0;
		for (int j = 0; j < i; j++) {//비교대상 j
			if (v[j] < v[i]) {
				mx = max(mx, memo[j]);
			}
		}
		memo[i] = mx + 1;
	}
	int mx = 0;
	for (int i = 0; i < n; i++) {
		mx = max(mx, memo[i]);
	}
	printf("%d", mx);

	return 0;
}