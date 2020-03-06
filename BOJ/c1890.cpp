#include <iostream>

#define MAX 100

using namespace std;

int N;
int map[MAX][MAX];
long long memo[MAX][MAX];

long long DP(int x, int y) {
	if (x >= N && y >= N) return 0;
	if (x == N - 1 && y == N - 1) return 1;
	if (map[x][y] == 0) return 0;
	if (memo[x][y] != 0) return memo[x][y];
	return memo[x][y] = DP(x + map[x][y], y) + DP(x, y + map[x][y]);
}

int main() {
	
	scanf("%d", &N);
	
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			scanf("%d", &map[i][j]);
		}
	}
	
	printf("%lld", DP(0, 0));

	return 0;
}