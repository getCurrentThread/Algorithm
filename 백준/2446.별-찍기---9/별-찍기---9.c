#include <stdio.h>

int main() {
	int n; scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (int j = i; j > 0; j--) {
			putchar(' ');
		}

		for (int j = (n - i) * 2 - 1; j > 0; j--) {
			putchar('*');
		}

		putchar('\n');
	}

	for (int i = n - 2; i >= 0; i--) {
		for (int j = i; j > 0; j--) {
			putchar(' ');
		}

		for (int j = (n - i) * 2 - 1; j > 0; j--) {
			putchar('*');
		}

		putchar('\n');
	}

	return 0;
}