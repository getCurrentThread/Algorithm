#include <iostream>
#include <algorithm>

#define MAX 1000000

using namespace std;

int x;
int dp[MAX + 1] = {0, 0, 1, 1};

int func(int x) {
	switch (x) {
	case 1: return 0;
	case 2: return 1;
	case 3: return 1;
	}
	if (dp[x] != 0) {
		return dp[x];
	}
	if (x % 6 == 0) {
		return dp[x] = min({ func(x / 3), func(x / 2), func(x - 1) }) + 1;
	}
	else if (x % 3 == 0) {
		return dp[x] = min({ func(x / 3), func(x - 1) }) + 1;
	}
	else if (x % 2 == 0) {
		return dp[x] = min({ func(x / 2), func(x - 1) }) + 1;
	}
	else {
		return dp[x] = func(x - 1) + 1;
	}
}

int main() {

	scanf("%d", &x);

	printf("%d", func(x));

	return 0;
}