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

/*
최솟값 = 0;

최댓값 = '배열의 길이' - 1 또는 '적절한 값' - 1

while (최솟값 <= 최댓값)

중간값 = 최솟값 + (최댓값 - 최솟값) / 2

if (원하는 값 < 중간값)

최댓값 = 중간값 - 1

else if (원하는 값 > 중간값)

최솟값 = 중간값 + 1

else (원하는 값이 중간값인 경우)

return 중간값

*/

long long CuttingTreeLength(int val) {
	long long sum = 0;
	for (auto it = lower_bound(v.begin(), v.end(), val); it != v.end(); it++) {
		sum += *it - val;
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

	int left = 0, right = v[v.size()-1], mid = (left + right) / 2;
	while (left <= right) {
		long long res = CuttingTreeLength(mid);
		if (res < m) {
			right = mid - 1;
		}
		else if (res > m) {
			left = mid + 1;
		}
		else {
			break;
		}
		mid = (left + right) / 2;
	}

	printf("%d", mid);

	return 0;
}