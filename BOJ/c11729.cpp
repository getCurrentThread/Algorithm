#include <iostream>
#include <vector>

using namespace std;

int n;
vector<pair<int, int> > v;

void hanoi(int n, int a, int b, int c) {

	if (n == 1) {
		v.push_back({ a, c });
	}
	else {
		hanoi(n - 1, a, c, b);
		v.push_back({ a, c });
		hanoi(n - 1, b, a, c);
	}

}

int main() {
	scanf("%d", &n);

	hanoi(n, 1, 2, 3);

	printf("%d\n", v.size());
	for (int i = 0; i < v.size(); i++) {
		printf("%d %d\n", v[i].first, v[i].second);
	}

	return 0;
}