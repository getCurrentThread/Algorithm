#include <stdio.h>
int main()
{
	int a;
	scanf("%d", &a);
	char ary[101];
	int sum = 0;
	scanf("%s", ary);
	for (int i = 0; i < a; i++)
	{
		sum += ary[i] - '0';
	}
	printf("%d", sum);
    return 0;
}