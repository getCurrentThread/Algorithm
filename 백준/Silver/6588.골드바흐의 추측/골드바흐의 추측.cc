#include <iostream>
#include <vector>
#include <bitset>
#include <cmath>

#define MAX 1000000

using namespace std;

int n;
int a, b;
bitset<MAX + 1> bit;
vector<int> prime;

void seive(int max) {
	int rmax = sqrt((double)max) + 1.0;
	bit.set(0); bit.set(1);
	for (int i = 2; i <= rmax; i++) {
		if (bit[i] == false) {
			for (int j = 2; (i * j) <= max; j++) {
				bit.set(i * j);
			}
		}
	}

	for (int i = 2; i <= max; i++) {
		if (bit[i] == false) {
			prime.push_back(i);
		}
	}

}

bool solve() {
	for (int i = 1; i < prime.size(); i++) {
		if (prime[i] >= n) {
			return false;
		}
		a = prime[i];
		for (int j = i; a + prime[j] <= n; j++) {
			b = prime[j];
			if (a + b == n) {
				return true;
			}

		}
	}
	return false;
}

int main() {
	seive(MAX);

	scanf("%d", &n);

	while (n) {
		if (solve()) {
			printf("%d = %d + %d\n", n, a, b);
		}
		else {
			printf("Goldbach's conjecture is wrong.\n");
		}
		scanf("%d", &n);
	}

	return 0;
}