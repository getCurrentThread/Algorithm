#include <iostream>

#define MAX 1000

using namespace std;

int memo[MAX + 1] = {0, 1, 3, 5};

int dp(int n) {
	if (n < 3 || memo[n] != 0) {
		return memo[n];
	}
	return memo[n] = (dp(n - 1) + (dp(n - 2) * 2)) % 10007;
}

int main() {
	int x;

	scanf("%d", &x);

	printf("%d", dp(x));

	return 0;
}