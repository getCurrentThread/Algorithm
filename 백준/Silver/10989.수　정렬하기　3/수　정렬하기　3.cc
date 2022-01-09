#include <iostream>

#define MAX 10000

using namespace std;

int arr[MAX + 1] = { 0, };

int main() {
	int num;
	int temp;
	

	scanf("%d", &num);


	for (int i = 0; i < num; i++) {
		scanf("%d", &temp);
		arr[temp]++;
	}

	for (int i = 0; i < (MAX+1); i++) {
		while(arr[i]){
			printf("%d\n", i);
			arr[i]--;
		}
	}

	return 0;
}