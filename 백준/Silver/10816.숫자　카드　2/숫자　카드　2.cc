#include <iostream>
#include <algorithm>

int arr[20000001];

using namespace std;

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);

	int n;
	cin >> n;

	int tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		arr[tmp+ 10000000]++;
	}

	//sort(arr, arr + n);

	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> tmp;
		cout << arr[tmp + 10000000] << " ";
	}

	return 0;
}