#include <iostream>
#include <algorithm>
#include <vector>

#define MAX 50

#define swap(a,b) ((temp) = (a),(a) = (b), (b)=(temp))

using namespace std;

int a[MAX + 1], b[MAX + 1];

int main() {

	int cnt;
	int sum = 0;

	scanf("%d", &cnt);

	for (int i = 0; i < cnt; i++)
	{
		scanf("%d", &a[i]);
	}

	for (int i = 0; i < cnt; i++)
	{
		scanf("%d", &b[i]);
	}

	sort(a, a + cnt);				  //내림차순
	sort(b, b + cnt, greater<int>()); //오름차순

	for (int i = 0; i < cnt; i++)
	{
		sum += a[i] * b[i];
	}

	printf("%d", sum);

		return 0;
}