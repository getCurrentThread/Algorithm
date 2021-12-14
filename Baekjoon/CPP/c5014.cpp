#include<iostream>
using namespace std;

int main(void) {
	int floor, start, goal;//floor, 1<=start, end(<=f<=100000)
	int up, down;//up, down
	int x, y;
	cin >> floor >> start >> goal >> up >> down;
	int diff = goal - start;

	if (up == 0 && down == 0) {
		if (diff == 0)	cout << 0;
		else			cout << "use the stairs";

		return 0;
	}
	else if (up == 0) {
		if (diff == 0)	cout << 0;
		else if (diff % down == 0 && diff / down <= 0) cout << -(diff / down);
		else			cout << "use the stairs";

		return 0;
	}
	else if (down == 0) {
		if (diff == 0)	cout << 0;
		else if (diff % up == 0 && diff / up >= 0) cout << diff / up;
		else			cout << "use the stairs";

		return 0;
	}
	else {
		for (x = 0; x < 1000000; x++) {
			if ((up * x - diff) / down < 0) continue;
			else if ((up * x - diff) % down == 0)
				break;
		}
		if (x == 1000000) {
			cout << "use the stairs";
			return 0;
		}
		y = (up * x - diff) / down;
		cout << (x + y);
		return 0;
	}
}