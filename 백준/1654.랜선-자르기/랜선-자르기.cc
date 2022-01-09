#include <iostream>
#include <algorithm>

using namespace std;

int k, n;
int arr[10000];

bool isCheck(int centi) {
	int sum = 0;
	for (int i = 0; i < k; i++) {
		sum += (arr[i] / centi);
	}
	return (sum >= n);
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);

	
	cin >> k >> n;
	
	for (int i = 0; i < k; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + k);
	
	long long left = 1, right = arr[k-1];
	long long mid = left + (right - left) / 2;
	while (left <= right) {
		if (isCheck(mid)) {
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}

		mid = left + (right - left) / 2;
	}
	cout << left - 1 << endl;

	return 0;
}