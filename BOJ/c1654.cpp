#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <cassert>

using namespace std;

int n, m;
vector<int> v;
int ans;

int temp;

int CuttingLenCount(int val) {
	int sum = 0;
	for (int i = 0; i < v.size(); i++) {
		sum += v[i] / val;
	}
	return sum;
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		v.push_back(temp);
	}

	sort(v.begin(), v.end());
	
	long long left = 0, right = v[v.size() - 1], mid = max(left + (right - left) / 2, 1ll);
	while (left <= right) {
		int res = CuttingLenCount(mid);
		if (res < m) { 
			right = mid - 1;
		}
		else if (res >= m) { //possible
			left = mid + 1;
		}
		mid = max(left + (right - left) / 2, 1ll);
	}
	
	printf("%d", mid-1);
	
	return 0;
}