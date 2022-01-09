#include <iostream>

using namespace std;

int main() {
	int n, sum = 0;
	char ch;
	
	scanf("%d\n", &n);
	for (int i = 0; i < n; i++) {
		scanf("%c", &ch);
		sum += ch - '0';
	}
	printf("%d", sum);
	return 0;
}