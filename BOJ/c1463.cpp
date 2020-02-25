#include <iostream>
#include <queue>
#include <bitset>

using namespace std;

int x;



int main() {
	
	scanf("%d", &x);


	queue<pair<int, int> > q;
	bitset<1000001> visit;
	pair<int, int> p;

	q.push({ x, 0 });
	visit[x] = true;

	while (!q.empty()) {
		p = q.front(); q.pop();
		x = p.first;
		if (x == 1)break;
		p.second++;
		if (x % 3 == 0) {
			q.push({x / 3, p.second});
			visit[x/3] = true;
		}
		if (x % 2 == 0) {
			q.push({ x / 2, p.second });
			visit[x / 2] = true;
		}
		if (x > 1) {
			q.push({ x - 1, p.second });
			visit[x - 1] = true;
		}
	}

	printf("%d", p.second);

	return 0;
}