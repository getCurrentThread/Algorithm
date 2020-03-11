#include<iostream>

#define MAX 1000

using namespace std;

int memo[MAX + 1][MAX + 1];

int dp(int n, int k) {
	if (k == 0 || k == n) return 1;
	if (memo[n][k]) return memo[n][k];
	return memo[n][k] = (dp(n - 1, k) + dp(n - 1, k - 1)) % 10007;
}

int main() {
	int n, k;
	scanf("%d%d",&n, &k);
	printf("%d", dp(n,k));
}