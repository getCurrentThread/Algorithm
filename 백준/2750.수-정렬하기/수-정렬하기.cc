#include <iostream>

#define MAX 1000+1
#define swap(a,b) (temp)=(a); (a)=(b); (b)=(temp);

using namespace std;


int arr[MAX];

void selectSort(int number, int arr[]) //오름차순 선택정렬
{
	int least, temp;
	for(int i = 0; i <number; i++){
		least = i;
		for (int j = i; j < number; j++) {
			if (arr[j] < arr[least])
				least = j;
		}
		swap(arr[i], arr[least]);
	}
}

int main() {

	int num;
	
	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%d", &arr[i]);
	}

	selectSort(num, arr);

	for (int i = 0; i < num; i++) {
		printf("%d\n", arr[i]);
	}

	return 0;
}