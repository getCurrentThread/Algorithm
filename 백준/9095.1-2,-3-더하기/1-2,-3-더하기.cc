#include <iostream>

using namespace std;

int target;
int ans;
int sum;

void dfs() {
	for (int i = 1; i <=3 && sum < target; i++) {
		sum += i;
		if (sum > target) {
			sum -= i;
			break;
		}
		else if (sum == target) {
			ans++;
		}
		else {
			dfs();
		}
		sum -= i;
	}
}

int main() {

	int Tcase;

	scanf("%d", &Tcase);

	for (int i = 0; i < Tcase; i++) {
		scanf("%d", &target);
		ans = 0;
		sum = 0;

		dfs();
		printf("%d\n", ans);
	}

	return 0;
}