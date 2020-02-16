#include <iostream>
#include <vector>

using namespace std;

int k;
int lotto[49];
vector<int> ans;

void dfs(int deep) {

	for (int i = 0; (deep+i) < k; i++) {
		ans.push_back(lotto[deep+i]);
		if (ans.size() == 6) { //print
			for (int i = 0; i < 5; i++)
				printf("%d ", ans[i]);
			printf("%d\n", ans[5]);

		}
		else{
			dfs(deep + i + 1);
		}
		ans.pop_back();
	}
}

int main() {

	scanf("%d", &k);
	while (k) {
		for (int i = 0; i < k; i++) {
			scanf("%d", lotto + i);
		}
		dfs(0);
		printf("\n");

		scanf("%d", &k);
	}

	return 0;
}