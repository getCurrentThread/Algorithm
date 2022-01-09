#include <iostream>

using namespace std;

int main() {
	int n;
	int mn, mx;
	scanf("%d", &n);
	
	int tmp;
	scanf("%d", &tmp);
	mn = mx = tmp;

	for (int i = 1; i < n; i++) {
		scanf("%d", &tmp);
		mn = mn > tmp ? tmp : mn;
		mx = mx < tmp ? tmp : mx;
	}

	printf("%d %d", mn, mx);

	return 0;
}