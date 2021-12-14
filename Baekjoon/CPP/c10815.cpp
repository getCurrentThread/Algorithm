#include <iostream>
#include <algorithm>

#define MAX 500000

int cards[MAX + 1];

using namespace std;

bool binarySearch(int list[], int start, int end, int target)
{
	int mid = start + ((end - start) / 2);

	while (end - start >= 0)
	{
		mid = start + ((end - start) / 2);

		if (target > list[mid]) {
			start = mid + 1;
		}
		else if(target < list[mid]) {
			end = mid - 1;
		}
		else {
			return true;
		}
	}

	return false;
}

int main() {

	int cCnt;
	int nInput;
	int x;

	scanf("%d", &cCnt);

	for (int i = 0; i < cCnt; i++)
	{
		scanf("%d", &cards[i]);
	}

	sort(cards, cards + cCnt);

	scanf("%d", &nInput);

	for (int i = 0; i < nInput; i++)
	{
		scanf("%d", &x);
		//if (binary_search(cards, cards + ccnt, x))
		if(binarySearch(cards, 0, cCnt, x))
		{
			printf("1 ");
		}
		else
		{
			printf("0 ");
		}
	}

	return 0;
}