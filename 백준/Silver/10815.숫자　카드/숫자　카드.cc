#include <iostream>
#include <algorithm>

int arr[500000];

using namespace std;

int main(){
	cin.tie(0);
	ios::sync_with_stdio(0);

	int n;
	cin >> n;
	

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr + n);

	int m;
	cin >> m;
	int tmp;
	for (int i = 0; i < m; i++) {
		cin >> tmp;
		int* ptr = lower_bound(arr, arr + n, tmp);
		if (ptr != arr + n && *ptr == tmp) {
			cout << "1 ";
		}
		else {
			cout << "0 ";
		}
	}

	return 0;
}