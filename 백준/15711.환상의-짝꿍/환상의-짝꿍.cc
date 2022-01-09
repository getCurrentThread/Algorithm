#include <iostream>
#include <bitset>
#include <vector>
#include <cmath>

#define MAX 2000000

using namespace std;

int t;
long long a, b, c;
bitset<MAX+1> bit;
vector<int> prime;

bool isPrime(long long a) {
	for (size_t i = 0; i < prime.size() && (long long)prime[i] * prime[i] <= a; i++) {
		if (a % prime[i] == 0) return false;
	}
	return true;
}

void seive(int max) {

	bit.set(0); bit.set(1);
	int rmax = sqrt((double)max) + 1.;
	for (int i = 2; i < rmax; i++) {
		if (bit[i] == false) {
			for (int j = 2; i * j <= max; j++) {
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
	if (c < 4) {
		return false;
	}
	else if (c % 2 == 0) {
		return true;
	}
	c -= 2;
	if (isPrime(c)) {
		return true;
	}
	return false;
}

int main() {

	seive(MAX);

	scanf("%d", &t);


	for (int i = 0; i < t; i++) {
		scanf("%lld %lld", &a, &b);
		c = a + b;

		if (solve()) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
	}

	return 0;
}