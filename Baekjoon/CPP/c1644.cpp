#include <iostream>
#include <cmath>
#include <vector>
#include <bitset>

#define MAX 4000000

using namespace std;

int n, ans;
int temp;
bitset<MAX + 1> b;
vector<int> prime;

void seive(int max) {
	b.set(0); b.set(1);
	int rmax = sqrt((double)max) + 1.;
	for (int i = 2; i < rmax; i++) {
		if (b[i] == false) {
			for (int j = 2; (i * j) <= max; j++) {
				b.set(i * j);
			}
		}
	}
	for(int i = 0; i <= max; i++){
		if(b[i] == false){
			prime.push_back(i);
		}
	}
}

void solve() {
	for (int i = prime.size() - 1; i >= 0; i--, temp=0) {
		temp = prime[i];
		if (temp > n) {
			continue;
		}
		else if(temp < n){
			for (int j = i - 1; j >= 0; j--) {
				temp += prime[j];
				if (temp > n) {
					break;
				}
				else if (temp == n) {
					ans++;
					break;
				}
			}
		}
		else if(temp == n){
			ans++;
		}
	}
}

int main() {

	scanf("%d", &n);

	seive(n);

	solve();

	printf("%d", ans);

	return 0;
}