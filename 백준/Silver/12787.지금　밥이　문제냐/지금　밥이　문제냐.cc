#include <iostream>

using namespace std;
typedef unsigned long long uint64;

int t, m;
uint64 n;

int main() {

	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d", &m);
		switch (m)
		{
		case 1:
			n = 0;
			int oct;
			for (int i = 0; i < 8; i++) {
				scanf("%d", &oct); getchar();
				n = (n << 8) + oct;
			}
			printf("%llu", n);
			break;
		case 2:
			scanf("%llu", &n);
			for (int i = 7; i >= 0; i--) {
				printf("%llu", (n >> (i * 8)) & (0xff));
				if (i >= 1) putchar('.');
			}
			break;
		}
		puts("");
	}
	return 0;
}