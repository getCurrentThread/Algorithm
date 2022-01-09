#include <iostream>
#include <algorithm>

#define MAX 100

using namespace std;

int n, k;
int coin[MAX];
int memo[100001];

int main() {
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &coin[i]);
	}

	sort(coin, coin + n);
	memo[0] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = coin[i]; j <= k; j++) {
			memo[j] += memo[j - coin[i]];
		}
	}

	printf("%d", memo[k]);

	return 0;
}