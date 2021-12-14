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
			printf("%ull", n << 8);
			break;
		case 2:
			scanf("%llu", &n);
			for (int i = 0; i < 8; i++) {
				printf("%d", (int)(n & (0xff00000000000000 >> (i*8))));
				if (i < 7) putchar('.');
			}
			break;
		}
		puts("");
	}
	return 0;
}