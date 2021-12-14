#include <iostream>
#include <vector>

using namespace std;

int n, temp;
int garosu[100001];

int gcm(int a, int b) {
	return a % b ? gcm(b, a % b) : b;
}

int main() {
	
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &garosu[i]);
	}

	for (int i = 1; i < n; i++) {
		garosu[i] -= garosu[0];
	}
	temp = gcm(garosu[1], garosu[2]);
	for (int i = 3; i < n; i++) {
		temp = gcm(temp, garosu[i]);
	}

	printf("%d", garosu[n-1]/temp - n + 1);

	return 0;
}