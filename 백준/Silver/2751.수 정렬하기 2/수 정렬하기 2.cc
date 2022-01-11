#include <iostream>
#include <bitset>

#define MAX 2000001

using namespace std;

bitset<MAX> counts;

int main() {
	int num;
	int temp;

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%d", &temp);
		counts.set(temp + 1000000);
	}



	for (int i = 0; i < MAX; i++) {
		if(counts[i])
			printf("%d\n", i-1000000);
	}

	return 0;
}