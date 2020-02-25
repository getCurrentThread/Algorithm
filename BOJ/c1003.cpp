#include <iostream>

#define MAX 40

using namespace std;

pair<int, int> f[MAX+1] = { {1,0}, {0,1} };

pair<int, int> operator+(const pair<int, int>& a, const pair<int, int>& b) {
	return { a.first + b.first, a.second + b.second };
}

pair<int, int> fibonacci(int n) {
	if (f[n].first != 0 || f[n].second != 0)
		return f[n];
	else
		return f[n] = fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
	int t, n;
	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d", &n);
		pair<int, int> ans = fibonacci(n);
		printf("%d %d\n", ans.first, ans.second);
	}

	return 0;
}