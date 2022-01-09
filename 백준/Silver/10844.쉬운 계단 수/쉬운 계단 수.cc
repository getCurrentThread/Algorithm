#include <iostream>

using namespace std;

int memo[101][11] = {0, };

int dp(int n, int digit) {
	if (n <= 1 || memo[n][digit] != 0) return memo[n][digit];
	int sum = 0;
	if (digit == 10) {
		for (int i = 0; i < 10; i++) {
			sum += dp(n, i);
			sum %= 1000000000;
		}
		return memo[n][digit] = sum;
	}
	if (digit - 1 >= 0) sum += dp(n - 1, digit - 1);
	if (digit + 1 < 10) sum += dp(n - 1, digit + 1);
	return memo[n][digit] = sum % 1000000000;
}

int main() {
	for (int i = 1; i < 10; i++) {
		memo[1][i] = 1;
	}
	memo[1][10] = 9;

	int n;
	scanf("%d", &n);
	printf("%d", dp(n, 10));
	return 0;
}