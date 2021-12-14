#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 10000

using namespace std;

int n, temp;
int v[MAX + 1];
int memo[MAX + 1];

int main() {
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &v[i]);
	}
	memo[0] = v[0];
	memo[1] = v[0] + v[1];
	memo[2] = max({ v[0], v[1], v[2], v[0] + v[1],v[1] + v[2], v[0] + v[2] });

	for (int i = 3; i < n; i++) {
		memo[i] = v[i] + max(v[i - 1] + memo[i - 3], memo[i - 2]);
		memo[i] = max(memo[i], memo[i - 1]);
	}

	printf("%d", memo[n-1]);

	return 0;
}