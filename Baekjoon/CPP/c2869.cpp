#include <iostream>

using namespace std;

int a, b, v; 
int ans;

int main() {
	// 1 <= b   <   a <= v <= 1'000'000'000
	scanf("%d %d %d", &a, &b, &v); //2 1 5 -> 4
	int m = v - a;
	int s = a - b;
	ans = (m%s == 0? (m/s):(m/s+1)) + 1;
	printf("%d", ans);

	return 0;
}