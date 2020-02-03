#include<stdio.h>
#define MAX 250

int board[MAX][MAX];//현수막
int m, n;

void delletter(int i, int j) {
	if (!(0 <= i && i <= MAX && 0 <= j && j <= MAX))
		return;
	board[i][j] = 0;
	if (board[i - 1][j - 1])	delletter(i - 1, j - 1);
	if (board[i - 1][j])		delletter(i - 1, j);
	if (board[i - 1][j + 1])	delletter(i - 1, j + 1);

	if (board[i][j - 1])		delletter(i, j - 1);
	if (board[i][j + 1])		delletter(i, j + 1);

	if (board[i + 1][j - 1])	delletter(i + 1, j - 1);
	if (board[i + 1][j])		delletter(i + 1, j);
	if (board[i + 1][j + 1])	delletter(i + 1, j + 1);
}

int main() {
	int count = 0;
	scanf("%d %d", &m, &n);// m과 n을 입력 받음

	for (int i = 0; i < m; i++) { //입력값을 보드에 넣음
		for (int j = 0; j < n; j++) {
			scanf("%d", &board[i][j]);
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] == 1) {
				delletter(i, j);
				count++;
			}
		}
	}
	printf("%d", count);
	return 0;
}