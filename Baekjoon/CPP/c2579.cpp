#include <iostream>
#include <algorithm>

#define MAX 300

using namespace std;

int n;
int stair[MAX+1];
int dp[MAX+1];

int func(int n) {
	dp[0] = stair[0];
	dp[1] = stair[0] + stair[1];
	dp[2] = max(stair[0] + stair[2], stair[1] + stair[2]);

	for (int i = 3; i < n; i++) {
		dp[i] = max(dp[i - 2] + stair[i]
				   ,dp[i - 3] + stair[i - 1] + stair[i]);
	}

	return dp[n-1];
}

int main() {
	
	scanf("%d", &n);
	for(int i = 0; i < n; i++){
		scanf("%d", &stair[i]);
	}

	printf("%d", func(n));

	return 0;
}