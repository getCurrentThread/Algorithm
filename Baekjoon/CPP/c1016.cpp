#include <iostream>
#include <bitset>
#include <vector>
#include <cmath>

#define MAX 1000000

using namespace std;

typedef long long int64;

bitset<1000001> b;
vector<int> prime;

bitset<1000001> chk;
int ans;

void seive(int max) {
	int rmax = sqrt((double)max) + 1.;
	b.set(0); b.set(1);
	for (int i = 0; i < rmax; i++) {
		if (b[i] == false) {
			for (int j = i+i; j <= max; j += i) {
				b.set(j);
			}
		}
	}
	for (int i = 0; i <= max; i++) {
		if (b[i] == false) {
			prime.push_back(i);
		}
	}
}

void sqrNoNoNumber(int64 min, int64 max) {
	for (int i = 0; i < prime.size(); i++) {
		int64 s = (int64)prime[i] * prime[i];
		if (s > max) break;
		int64 j = (min%s)? (min/s+1)*s:min;
		for (; j <= max; j += s) {
			chk.set(j - min);
		}
	}
	int lm = max - min;
	for (int i = 0; i <= lm; i++) {
		if(chk[i]== false)
			ans++;
	}
}

int main() {
	int64 mn, mx;

	scanf("%lld %lld", &mn, &mx);

	seive(MAX);

	sqrNoNoNumber(mn, mx);

	printf("%d", ans);

	return 0;
}