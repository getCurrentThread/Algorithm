#include <iostream>
#include <algorithm>

#define MAX 100000

using namespace std;

typedef struct _POINT {
	int x;
	int y;
}POINT;

bool ComparePoint(POINT& a, POINT& b)
{
	if (a.y == b.y) {
		return a.x < b.x;
	}
	else {
		return a.y < b.y;
	}
}

POINT arr[MAX + 1];

int main() {

	int cnt;

	scanf("%d", &cnt);

	for (int i = 0; i < cnt; i++)
	{
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}

	sort(arr, arr + cnt, ComparePoint);

	for (int i = 0; i < cnt; i++)
	{
		printf("%d %d\n", arr[i].x, arr[i].y);
	}

	return 0;
}