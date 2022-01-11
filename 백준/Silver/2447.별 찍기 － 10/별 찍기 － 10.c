#include <stdio.h>
#include <string.h>

char map[6563][6563];
int posX[] = { 0, 0, 0, 1,  1, 2, 2, 2 };
int posY[] = { 0, 1, 2, 0,  2, 0, 1, 2 };

void drawSquare(int x, int y, int length) {
	if (length == 3) {
		for (int i = 0; i < 8; i++) {
			map[x + posX[i]][y + posY[i]] = '*';
		}
		return;
	}
	int lengthDiv3 = length / 3;
	for (int i = 0; i < 8; i++) {
		drawSquare(x + (posX[i] * lengthDiv3), y + (posY[i] * lengthDiv3), lengthDiv3);
	}
}

int main() {
	int n; scanf("%d", &n);
	memset(map, ' ', sizeof(map));

	drawSquare(0, 0, n);
	for (int i = 0; i < n; i++) {
		map[i][n] = '\0';
		printf("%s\n", map[i]);
	}
	return 0;
}