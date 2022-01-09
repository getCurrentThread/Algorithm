#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/*
n : 집 개수
c : 공유기 개수
*/
int n, c;
vector<int> h;

int temp;

int isPossible(const int length) {
	int cnt = 0, sel = -1000000000;
	for (int i = 0; i < h.size(); i++) {
		if (length <= h[i] - sel) {
			sel = h[i];
			cnt++;
		}
	}
	if(c <= cnt){
		return true;
	}
	else {
		return false;
	}
}

int main() {
	scanf("%d %d", &n, &c);
	h.resize(n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		h[i] = temp;
	}

	sort(h.begin(), h.end());

	int left = 0, right = h[h.size() - 1] - h[0], mid = left + (right - left) / 2;
	while (left <= right) {
		bool ans = isPossible(mid);
		if (ans == true)
			left = mid + 1;
		else
			right = mid - 1;
		mid = left + (right - left) / 2;
	}

	printf("%d", mid-1);

	return 0;
}