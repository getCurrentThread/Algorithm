#include <iostream>
#include  <queue>

#define MAX 100

using namespace std;

typedef struct _node {
	int x;
	int y;
	int z;
	int day;
}node;

int l, n, m;
char box[MAX + 1][MAX + 1][MAX + 1];

int posX[] = { 0, 0, 0, 0, 1, -1 };
int posY[] = { 0, 0, 1, -1, 0, 0 };
int posZ[] = { 1, -1, 0, 0, 0, 0 };
int zCnt;
queue<node > q;
node p;

int ans;

int main() {

	scanf("%d %d %d", &m, &n, &l);

	int tmp;
	for (int k = 0; k < l; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				scanf("%d", &tmp);
				box[k][i][j] = tmp;
				if (tmp == 0) zCnt++;
				else if (tmp == 1) {
					q.push({ i, j, k, 0 });
				}
			}
		}
	}

	while (!q.empty()) {
		if (zCnt == 0) break;
		p = q.front(); q.pop();
		for (int i = 0; i < 6; i++) {
			int mx = p.x + posX[i];
			int my = p.y + posY[i];
			int mz = p.z + posZ[i];
			if (0 <= mx && mx < n &&
				0 <= my && my < m &&
				0 <= mz && mz < l &&
				box[mz][mx][my] == 0) {
				box[mz][mx][my] = 1;
				q.push({ mx, my, mz, p.day + 1 });
				zCnt--;
				if (zCnt == 0) {
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