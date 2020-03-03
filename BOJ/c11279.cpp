#include <iostream>
#include <queue>

using namespace std;

int n;
priority_queue<int> pq;

int temp;

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		if (temp == 0) {
			if (pq.empty()) {
				puts("0");
			}
			else {
				printf("%d\n", pq.top()); pq.pop();
			}
		}
		else {
			pq.push(temp);
		}
	}

	return 0;
}