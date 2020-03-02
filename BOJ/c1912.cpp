#include <iostream>
#include <vector>
#include <limits>
#include <algorithm>

#define MAX 100000

using namespace std;

int maximum;
int ary[MAX + 1];
int dp[MAX + 1];

int n, temp;

int main() {
	
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &ary[i]);
	}


	maximum = dp[0] = ary[0];
	for (int i = 1; i < n; i++) {
		dp[i] = max(dp[i - 1] + ary[i], ary[i]);
		maximum = max(maximum, dp[i]);
	}


	printf("%d", maximum);

	return 0;
}