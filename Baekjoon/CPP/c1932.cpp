#include <iostream>
#include <algorithm>

#define MAX 500

using namespace std;

int n;
int dp[MAX + 1];
int ary[MAX + 1];

int main() {

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			scanf("%d", &ary[j]);
		}
		if (i == 0) { dp[0] = ary[0]; continue; }

		for (int j = 1; j < i; j++) {
			ary[j] = max(dp[j] + ary[j], dp[j-1] + ary[j]);
		}
		ary[0] = dp[0] + ary[0];
		ary[i] = dp[i - 1] + ary[i];

		for (int i = 0; i <= n; i++) {
			dp[i] = ary[i];
		}
	}

	sort(dp, dp + n);

	printf("%d", dp[n-1]);


	return 0;
}