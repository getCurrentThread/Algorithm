#include <iostream>

using namespace std;

int gcd(int a, int b) { //최대공약수
	return a % b ? gcd(b, a % b) : b;
}

int lcm(int a, int b) { //최소공배수
	return a * (b / gcd(a, b));
}

int main() {

	int a, b;
	scanf("%d %d", &a, &b);

	printf("%d\n%d",gcd(a,b), lcm(a,b));

	return 0;
}