#include <iostream>

#define MAX 2000001

using namespace std;

int counts[MAX];

int main() {
	int num;
	int temp;

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%d", &temp);
		counts[temp + 1000000]++;
	}



	for (int i = 0; i < MAX; i++) {
		if(counts[i])
			printf("%d\n", i-1000000);
	}

	return 0;
}