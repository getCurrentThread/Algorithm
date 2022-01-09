#include <iostream>

using namespace std;

int n, s;
int elements[21];
int sum = 0;
int ans = 0;

void dfs(int deep) {
	
	if (deep == (n-1))
	{
		if (sum == s)
			ans++;
		sum += elements[deep];
		if (sum == s)
			ans++;
		sum -= elements[deep];
	}
	else{
		dfs(deep + 1);
		sum += elements[deep];
		dfs(deep + 1);
		sum -= elements[deep];
	}
}

int main() {

	scanf("%d %d", &n, &s);

	for (int i = 0; i < n; i++) {
		scanf("%d", elements+i);
	}
	if (s == 0) ans = -1;
	else ans = 0;

	dfs(0);

	printf("%d", ans);

	return 0;
}