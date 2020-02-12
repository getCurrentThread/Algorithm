#include <iostream>
#include <algorithm>

#define MAX 500000

using namespace std;

int a[MAX + 1];
int b[MAX + 1];


int main() {

	int a_cnt, b_cnt;

	scanf("%d", &a_cnt);
	for (int i = 0; i < a_cnt; i++)
	{
		scanf("%d", &a[i]);
	}

	scanf("%d", &b_cnt);
	for (int i = 0; i < b_cnt; i++)
	{
		scanf("%d", &b[i]);
	}

	sort(a, a + a_cnt);
	for (int i = 0; i < b_cnt; i++)
	{
		pair<int*, int*> pInt = equal_range(a, a + a_cnt, b[i]);
		printf("%d ", pInt.second - pInt.first);
	}

	return 0;
}