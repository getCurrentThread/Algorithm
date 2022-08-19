#include <iostream>
#include <vector>

using namespace std;

int n, k;
int ans;
vector<int> v;


int main() {
	scanf("%d %d", &n, &k);
	v.resize(n);
	
	int temp;
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		v[i] = temp;
	}

	int cnt;
	for (int i = n - 1; i >= 0; i--) {
		if (cnt = k / v[i]) {
			ans += cnt;
			k %= v[i];
		}
	}

	printf("%d", ans);

	return 0;
}