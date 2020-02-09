#include <iostream>

#define swap(a,b) (temp) = (a); (a) = (b); (b) = (temp); 

#define MAX 10000001

using namespace std;

int arr[MAX];

int partition(int list[], int left, int right) {
	int temp;
	int low, high, mid, pivot;

	mid = left + ((right - left) / 2);
	low = left+1; high = right;

	swap(list[left], list[mid]);

	pivot = list[left];

	while (low < high)
	{
		for (; low <= high && list[low] < pivot; low++);
		for (; low <= high && list[high] > pivot; high--);

		if (low < high){
			swap(list[low], list[high]);
		}
	}

	swap(list[left], list[high]);
	
	return high; //pivot 위치 반환.
}

void quickSort(int list[], int left, int right) {

	if (left >= right)
		return;

	int p = partition(list, left, right);

	quickSort(list, left, p - 1);
	quickSort(list, p + 1, right);
}


int main() {
	int num;
	

	scanf("%d", &num);


	for (int i = 0; i < num; i++) {
		scanf("%d", &arr[i]);
	}

	quickSort(arr, 0, num-1);

	for (int i = 0; i < num; i++) {
		printf("%d\n", arr[i]);
	}

	return 0;
}