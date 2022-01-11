#include <iostream>
#include <vector>
#include <queue>

#define MAX 100
#define INF 987654321

using namespace std;

const int posX[] = { 0, 0, 1, -1 };
const int posY[] = { 1, -1, 0, 0 };
char map[MAX + 1][MAX + 1];
int dist[MAX + 1][MAX + 1];

struct Node {
	int x, y;
	int w;
};

bool operator<(const Node& a, const Node& b) {
	return a.w > b.w;
}

priority_queue<Node> pq;

int main() {
	int row, col;
	
	scanf("%d%d", &row, &col);
	for (int i = 0; i < col; i++) {
		scanf("%s", &map[i]);
	}
	for (int i = 0; i < col; i++) {
		for (int j = 0; j < row; j++) {
			dist[i][j] = INF;
			map[i][j] -= '0';
		}
	}
	dist[0][0] = 0;
	pq.push({ 0,0,0 });

	while (!pq.empty()) {
		int xu = pq.top().x, yu = pq.top().y;
		int d = pq.top().w; pq.pop();
		if (d > dist[xu][yu]) continue;
		for (int i = 0; i < 4; i++) {
			int xv = xu + posX[i], 
				yv = yu + posY[i];
			if( 0 <= xv && xv < col
				&& 0 <= yv && yv < row
				&& dist[xv][yv] > map[xv][yv] + d) {
					dist[xv][yv] = map[xv][yv] + d;
					pq.push({ xv, yv, dist[xv][yv] });
			}
		}
	}

	printf("%d", dist[col - 1][row - 1]);

	return 0;
}