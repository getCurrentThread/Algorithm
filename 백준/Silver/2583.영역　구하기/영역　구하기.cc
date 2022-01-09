#include <iostream>
#include <bitset>
#include <vector>
#include <algorithm>

#define MAX 100

using namespace std;

int m, n, k;
int cnt;

bitset<MAX + 1> ary[MAX + 1];
vector<int> ans;

typedef struct _pos {
	int x, y;
}Pos;

typedef struct _rect {
	int sx, sy;
	int ex, ey;
}Rect;

Rect rect;
Pos pos;

const int posX[] = { 0, 0, 1, -1 };
const int posY[] = { 1, -1, 0, 0 };

void dfs(int x, int y) {
	ary[x][y] = true; cnt++;
	for (int i = 0; i < 4; i++) {
		int mx = x + posX[i];
		int my = y + posY[i];
		if (0 <= mx && mx < n &&
			0 <= my && my < m &&
			!ary[mx][my]) {
			dfs(mx, my);
		}
	}
}

int main() {
	scanf("%d %d %d", &m, &n, &k); //5 7 3 x,y(0,0) ~ (7,5) (x,y) ->(n, m)

	for (int i = 0; i < k; i++) {
		scanf("%d %d %d %d", &rect.sx, &rect.sy, &rect.ex, &rect.ey);
		for (int x = rect.sx; x < rect.ex; x++) {
			for (int y = rect.sy; y < rect.ey; y++) {
				ary[x][y] = true;
			}
		}
	}
	
	for (int x = 0; x < n; x++) {
		for (int y = 0; y < m; y++) {
			if (!ary[x][y]) {
				cnt = 0;
				dfs(x, y);
				ans.push_back(cnt);
			}
		}
	}

	sort(ans.begin(), ans.end());

	printf("%d\n", ans.size());
	for (int i = 0; i < ans.size(); i++) {
		printf("%d ", ans[i]);
	}

	return 0;
}