#include <iostream>
#include <bitset>
#include <queue>

#define MAX 100

using namespace std;

typedef struct _Point {
	int x;
	int y;
}Point;

int n, m;
char maze[MAX + 1][MAX + 1];
bitset<MAX + 1> visit[MAX + 1];

int posX[] = { 0,0,1,-1 };
int posY[] = { 1,-1,0,0 };

queue<pair<Point, int> > q;
pair<Point, int> p;

int main() {
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf("%s", maze[i]);
	}

	n--; m--;

	q.push({ {0,0},1 });
	visit[0][0] = true;

	while (!q.empty()) {
		p = q.front(); q.pop();
		if (p.first.x == n && p.first.y == m) break;
		for (int i = 0; i < 4; i++) {
			int mx = p.first.x + posX[i];
			int my = p.first.y + posY[i];
			if (0 <= mx && mx <= MAX &&
				0 <= my && my <= MAX &&
				maze[mx][my] == '1' &&
				!visit[mx][my]) {
				q.push({ {mx,my},p.second + 1 });
				visit[mx][my] = true;
			}
		}
	}

	printf("%d", p.second);

	return 0;
}