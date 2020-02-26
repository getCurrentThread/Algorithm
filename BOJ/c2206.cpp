#include <iostream>
#include <queue>
#include <bitset>

#define MAX 1000

using namespace std;

typedef struct _pos {
	int x;
	int y;
}POS;

int n, m;
char maze[MAX + 1][MAX + 1];
queue<pair<pair<POS, int>, bool> > q;
char visit[MAX + 1][MAX + 1];

pair<pair<POS, int>, bool> p;

int posX[] = { 0, 0, 1, -1 };
int posY[] = { -1, 1, 0 ,0 };

int main() {
	
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf("%s", maze[i]);
	}

	q.push({ {{0,0},1}, false });
	visit[0][0] = 2;

	while (!q.empty()) {
		p = q.front(); q.pop();
		if (p.first.first.x == n - 1 && p.first.first.y == m - 1) break;
		for (int i = 0; i < 4; i++) {
			int mx = p.first.first.x + posX[i]; int my = p.first.first.y + posY[i];
			if (0 <= mx && mx <= MAX &&
				0 <= my && my <= MAX) {
				if (visit[mx][my] == 2 || (visit[mx][my] == 1 && p.second == true)) {
					continue;
				}
				
				if (maze[mx][my] == '0') {
					q.push({ {{ mx, my },p.first.second + 1 }, p.second });
					if(p.second == false){
						visit[mx][my] = 2;
					}
					else {
						visit[mx][my] = (visit[mx][my] == 2) ? 2 : 1;
					}
				}
				else if (p.second == false) { // '1'
					q.push({ {{ mx, my },p.first.second + 1 }, true });
					visit[mx][my] = 1;
				}
			}
		}
	}

	if (p.first.first.x != n - 1 || p.first.first.y != m - 1) {
		printf("-1");
	}
	else {
		printf("%d", p.first.second);
	}


	return 0;
}