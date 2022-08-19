#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>

#define MAX 1000

using namespace std;

string a(MAX + 2, '\0'), b(MAX + 2, '\0');
int memo[MAX + 1][MAX + 1];
int aSize, bSize;


int main() {
	scanf("%s", &a[1]);				scanf("%s", &b[1]);
	aSize = strlen(&a[1]);	bSize = strlen(&b[1]);

	for (int i = 1; i <= aSize; i++) {
		for (int j = 1; j <= bSize; j++) {
			if (a[i] == b[j]) {
				memo[i][j] = memo[i - 1][j - 1] + 1;
			}
			else {
				memo[i][j] = max(memo[i - 1][j], memo[i][j - 1]);
			}
		}
	}
	printf("%d", memo[aSize][bSize]);

	return 0;
}