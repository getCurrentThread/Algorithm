#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int map[100001][2];
int memo[100001][2];

int dp(int n, int upDown) {
	if (n <= 1 || memo[n][upDown] != -1) return memo[n][upDown];
	int tmp = (upDown == 0) ? dp(n - 1, 1) : dp(n - 1, 0);
	return memo[n][upDown] = max({ tmp, dp(n - 2, 0), dp(n - 2, 1) }) + map[n][upDown];
}

int main() {
	int Tcase;
	scanf("%d", &Tcase);
	for (int i = 0; i < Tcase; i++) {
		memset(map, 0, sizeof(map));
		memset(memo, -1, sizeof(memo));
		
		int N;
		scanf("%d", &N);
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < N; i++) {
				scanf("%d", &map[i][j]);
			}
		}
		memo[0][0] = map[0][0]; memo[0][1] = map[0][1];
		memo[1][0] = map[0][1] + map[1][0];
		memo[1][1] = map[0][0] + map[1][1];

		printf("%d\n", max(dp(N - 1, 1), dp(N - 1, 0)));
	}

	return 0;
}