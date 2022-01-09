#include <iostream>

using namespace std;

int main() {
	int Tcase;
	scanf("%d", &Tcase);

	int a, b;
	for (int i = 0; i < Tcase; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", a + b);
	}

	return 0;
}