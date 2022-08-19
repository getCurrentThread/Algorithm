#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int h, m;
	cin >> h >> m;
	m -= 45;
	if (m < 0) {
		m += 60;
		h = (h + 24 - 1) % 24;
	}
	cout << h << " " << m;
	return 0;
}