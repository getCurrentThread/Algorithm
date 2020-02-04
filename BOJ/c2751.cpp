#include <iostream>
//#include <algorithm>

#define MAX 1000001
#define swap(a,b) (temp) = (a); (a) = (b); (b) = (temp);

int arr[MAX];

int partition(int list[], int left, int right)
{
	int temp;
	int high, low, pivot;
	
	pivot = list[left];
	low = left+1; 
	high = right;

	do {
		for (; low <= high && list[low] < pivot; low++);
		for (; low <= high && list[high] > pivot; high--);

		if (low < high) {
			swap(list[low], list[high]);
		}

	} while (low < high);

	swap(list[left], list[high]); //low ,high가 교체한 위치에 피벗 넣기.

	return high; //피벗 위치
}

void quickSort(int list[], int left, int right)
{
	if (left < right){
	
		int q = partition(list, left, right); //피벗

		quickSort(list, left, q - 1); //피벗보다 작은 왼쪽 리스트 정복
		quickSort(list, q + 1, right);//피벗보다 큰 오른쪽 리스트 정복
	}
}

int main() {
	int num;

	scanf("%d", &num);

	for (int i = 0; i < num; i++) {
		scanf("%d", &arr[i]);
	}

	quickSort(arr, 0, num-1);
	//std::sort(arr, arr+num);

	for(int i = 0; i < num; i++){
		printf("%d\n", arr[i]);
	}

	return 0;
}