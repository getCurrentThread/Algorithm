#include <iostream>
#include  <queue>

#define MAX 1000

using namespace std;

typedef struct _node {
	int x;
	int y;
	int day;
}node;

int n, m;
char box[MAX + 1][MAX + 1];

int posX[] = { 0, 0, 1, -1 };
int posY[] = { 1, -1, 0, 0 };

int zCnt;
queue<node > q;
node p;

int ans;

int main() {

	scanf("%d %d", &m, &n);

	int tmp;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &tmp);
			box[i][j] = tmp;
			if (tmp == 0) zCnt++;
			else if (tmp == 1) {
				q.push({ i, j, 0 });
			}
		}
	}

	while (!q.empty()) {
		if (zCnt == 0) break;
		p = q.front(); q.pop();
		for (int i = 0; i < 4; i++) {
			int mx = p.x + posX[i];
			int my = p.y + posY[i];
			if (0 <= mx && mx < n &&
				0 <= my && my < m &&
				box[mx][my] == 0){
				box[mx][my] = 1;
				q.push({ mx, my, p.day + 1 });
				zCnt--;
				if (zCnt == 0){
					ans = p.day + 1;
					break;
				}
			}
		}
	}

	if (zCnt != 0) {
		puts("-1");
	}
	else {
		printf("%d", ans);
	}

	return 0;
}