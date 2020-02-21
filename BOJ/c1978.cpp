#include <iostream>
#include <bitset>
#include <cmath>

#define MAX 1000

using namespace std;

bitset<MAX + 1> unprime;


bool isPrime(int num) {
	return !unprime[num];
}

void sieve(int max) {
	int rmax = sqrt((double)max) + 0.5;
	
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

	int n, temp;
	int cnt = 0;
	
	sieve(MAX);
	
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		if (isPrime(temp)) {
			cnt++;
		}
	}

	printf("%d", cnt);

	return 0;
}