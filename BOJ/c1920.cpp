#include <iostream>
#include <bitset>

#define MAX 500

using namespace std;

int N, M, H;
int map[MAX][MAX];
int memo[MAX][MAX];
bitset<MAX> visited[MAX];

const int posX[] = { 0, 0, 1, -1 };
const int posY[] = { 1, -1, 0, 0 };

int DP(int x, int y) {
	if (x >= N && y >= M) return 0;
	if (x == N - 1 && y == M - 1) return 1;
	if (visited[x][y]) return memo[x][y];
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nx = x + posX[i];
		int ny = y + posY[i];
		if (0 <= nx && nx < N &&
			0 <= ny && ny < M &&
			map[x][y] > map[nx][ny]) {
			memo[x][y] += DP(nx, ny);
		}
	}
	return memo[x][y];
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
		}
	}

	cout << DP(0, 0);

	return 0;
}