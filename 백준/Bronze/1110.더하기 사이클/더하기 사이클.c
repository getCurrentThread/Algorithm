#include<stdio.h>

int main(void) {
	int num, origin, count = 0;
	scanf("%d" ,&origin);
	num = origin;
	do {
		count++;
		if (num < 10) num = num * 11;
		else num = (num % 10 * 10) + ((num % 10 + num / 10) % 10);
	} while (origin != num);

	printf("%d",count);
	return 0;
}