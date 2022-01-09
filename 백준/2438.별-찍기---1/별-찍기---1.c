#include <stdio.h>

int main() {
	int n; scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for(int j = n - i; j < n; j++){
			putchar('*');
		}
		putchar('\n');
	}

	return 0;
}