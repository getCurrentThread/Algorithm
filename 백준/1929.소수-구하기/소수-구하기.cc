#include <iostream>
#include <bitset>
#include <cmath>

#define MAX 1000000

using namespace std;

bitset<MAX + 1> unprime;

bool isPrime(int num) {
	return !unprime[num];
}

void seive(int max) {
	int rmax = sqrt((double)max) + 1.;

	unprime.set(1);
	for (int i = 2; i < rmax; i++) {
		if (isPrime(i)) {
			for (int j = 2 * i; j <= max; j += i) {
				unprime.set(j);
			}
		}
	}
}

int main() {

	int n, m;

	scanf("%d %d", &n, &m);

	seive(MAX);

	for (int i = n; i <= m; i++) {
		if (isPrime(i)) {
			printf("%d\n", i);
		}
	}

	return 0;
}