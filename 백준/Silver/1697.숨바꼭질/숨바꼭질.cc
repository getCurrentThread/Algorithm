#include <iostream>
#include <queue>
#include <bitset>

#define MAX 100000

using namespace std;

queue<pair<int, int>> q;
pair<int, int> p;
bitset<MAX + 1> visit;
int ans;

int main() {
	int n, k;
	scanf("%d %d", &n, &k);

	visit.set(n);
	q.push({ n, 0 });

	while (!q.empty()) {
		p = q.front(); q.pop();

		n = p.first; 
		if (n == k) break;

		p.second++;

		if (n + 1 <= MAX && !visit[n + 1]) {
			q.push({ n + 1, p.second });
			visit.set(n + 1);
		}

		if (n * 2 <= MAX && !visit[n * 2]) {
			q.push({ n * 2, p.second });
			visit.set(n * 2);
		}

		if (n - 1 >= 0 && !visit[n - 1]) {
			q.push({ n - 1, p.second });
			visit.set(n - 1);
		}

	}

	printf("%d", p.second);

	return 0;
}