#include <iostream>

#define MAX 1000

using namespace std;

int n;
int memo[MAX + 1] = {0, 1, 2};

int dp(int n) {
	if (n < 3 || memo[n] != 0) {
		return memo[n];
	}
	return memo[n] = (dp(n - 1) + dp(n - 2)) % 10007;
}

int main() {
	scanf("%d", &n);

	printf("%d", dp(n));

	return 0;
}