#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		scanf("%d", &n);

		int arr[200];
		memset(arr, 0, sizeof(arr));

		int a, b;
		for (int i = 0; i < n; i++) {
			scanf("%d%d", &a, &b);
			if (a == b) continue;
			a = (a - 1) / 2; b = (b - 1) / 2;
			if (a > b) swap(a, b);
			for (int i = a; i <= b; ++i) {
				++arr[i];
			}
		}
		int mx = 0;
		for (int i = 0; i < 200; i++) {
			mx = max(mx, arr[i]);
		}
		printf("#%d %d\n", test_case, mx);
	}
	return 0;
}