#include <iostream>
#include <queue>

using namespace std;

int n, temp;
typedef struct _cmp{
	bool operator()(const int& a, const int& b) {
		if (abs(a) == abs(b)) {
			return a > b;
		}
		return abs(a) > abs(b);
	}
}compareABS;
priority_queue<int, vector<int>, compareABS> pq;

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