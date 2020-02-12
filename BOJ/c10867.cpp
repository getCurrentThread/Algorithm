#include <iostream>
#include <algorithm>

#define MAX 100000

using namespace std;

int arr[MAX + 1];

int main() {

	int cnt;
	int* end;

	scanf("%d", &cnt);

	for (int i = 0; i < cnt; i++)
	{
		scanf("%d", &arr[i]);
	}

	sort(arr, arr + cnt);

	end = unique(arr, arr + cnt);

	for (int* it = arr; it != end; it++)
	{
		printf("%d ", *it);
	}

	return 0;
}