#include <iostream>

using namespace std;

int lcd(int a, int b) {
	return a % b ? lcd(b, a % b) : b;
}

int gcd(int a, int b) {
	return a * (b / lcd(a, b));
}

int main() {

	int a, b;
	scanf("%d %d", &a, &b);

	printf("%d\n%d",lcd(a,b), gcd(a,b));

	return 0;
}