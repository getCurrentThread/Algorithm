#include <iostream>
#include <vector>
#include <queue>
#include <bitset>

#define MAX 100

using namespace std;
typedef struct _point { 
	int x, y;
}Point;

typedef struct _node {
	Point pos;
	int day;
}Node;

int row, col;
int ary[MAX + 1][MAX + 1];
bitset<MAX + 1> visited[MAX + 1];
int ans[MAX + 1];
queue<Node> q;

const int posX[] = { 0, 0, -1, 1 };
const int posY[] = { -1, 1, 0, 0 };

void removeAirDFS(int x, int y, int day = 0) {
	ary[x][y] = -1;
	visited[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int mx = x + posX[i];
		int my = y + posY[i];
		if (0 <= mx && mx < row &&
			0 <= my && my < col &&
			!visited[mx][my]) {
			if (ary[mx][my] == 0) {
				removeAirDFS(mx, my, day);
			}
			else if(ary[mx][my] == 1) { //공기와 노출된 치즈.
				q.push({mx, my, day});
				visited[mx][my] = true;
			}
		}
	}
}

int main() {
	scanf("%d %d", &row, &col);
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			scanf("%d", &ary[i][j]);
		}
	}

	removeAirDFS(0, 0); //init : remove air & add Chz expire.

	Node node;
	while (!q.empty()) {
		node = q.front(); q.pop();

		ary[node.pos.x][node.pos.y] = -1;
		ans[node.day]++;
		
		for (int i = 0; i < 4; i++) {
			int mx = node.pos.x + posX[i];
			int my = node.pos.y + posY[i];
			if (0 <= mx && mx < row &&
				0 <= my && my < col &&
				!visited[mx][my]) {
				if (ary[mx][my] == 0) {
					removeAirDFS(mx, my, node.day + 1);
				}
				else if (ary[mx][my] == 1) { //공기와 노출된 치즈.
					q.push({ mx, my, node.day + 1 });
					visited[mx][my] = true;
				}
			}
		}
	}
	int day = node.day;

	printf("%d\n", day+1);
	printf("%d", ans[day]);

	return 0;
}