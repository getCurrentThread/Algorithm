#include <iostream>
#include <algorithm>

#define MAX 1000

using namespace std;

int n;
int ary[MAX + 1][3];
int dp[MAX + 1][3];

int main() {

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &ary[i][0], &ary[i][1], &ary[i][2]);
	}
	dp[0][0] = ary[0][0]; dp[0][1] = ary[0][1]; dp[0][2] = ary[0][2];
	for (int i = 1; i < n; i++) {
		dp[i][0] = ary[i][0] + min(dp[i - 1][1], dp[i - 1][2]);
		dp[i][1] = ary[i][1] + min(dp[i - 1][0], dp[i - 1][2]);
		dp[i][2] = ary[i][2] + min(dp[i - 1][0], dp[i - 1][1]);
	}

	printf("%d", min({dp[n-1][0],dp[n - 1][1],dp[n - 1][2] }));

	return 0;
}