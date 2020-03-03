#include <iostream>
#include <queue>

using namespace std;

priority_queue<int, vector<int>, greater<int> > pq;

int main() {
	int n, temp;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		pq.push(temp);
	}
	int ans = 0;
	while (pq.size() >= 2) {
		temp = pq.top(); pq.pop();
		temp += pq.top(); pq.pop();
		ans += temp;
		pq.push(temp);
	}
	printf("%d", ans);

	return 0;
}