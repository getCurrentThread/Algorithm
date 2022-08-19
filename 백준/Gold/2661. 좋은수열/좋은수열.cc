#include <iostream>

#define MAX 80

using namespace std;

int n;
int seq[MAX];

bool isSamePattern(int deep) {
	
	for (int i = 2; i < deep; i++) {
		int cnt = 0;
		for (int j = deep; (j - i) >= 0; j--) {
			if (seq[j] == seq[j - i]) {
				cnt++;
			}
			else {
				break;
			}
		}
		if (cnt == i) {
			return true;
		}
	}

	return false;
}

bool solve(int term) {
	for (int i = 1; i <= 3; i++) {
		seq[term] = i;
		if (term != 0 && seq[term] == seq[term-1]) { // 빠른 스킵
			continue;
		}
		if (isSamePattern(term)) {
			continue;
		}
		if (term == (n-1)) {
			return true;
		}
		else{
			if (solve(term + 1)) {
				return true;
			}
		}
	}
	return false;
}

int main() {
	
	scanf("%d", &n);

	solve(0);

	for (int i = 0; i < n; i++) {
		printf("%d", seq[i]);
	}

	return 0;
}