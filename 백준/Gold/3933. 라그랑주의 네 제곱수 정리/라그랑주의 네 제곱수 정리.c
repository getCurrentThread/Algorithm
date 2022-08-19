#include<stdio.h>

#define MAX_VALUE 32768
#define MAX_SQR 183

unsigned int result[MAX_VALUE+1] = { 0, };
unsigned int sqrNum[MAX_SQR] = { 0, };


int main(void) {
	for (unsigned int i = 0; i < MAX_SQR; i++) {
		sqrNum[i] = i * i;
	}
	int res = 0;
	for (int i = 0; i < MAX_SQR; i++) {
		for (int j = i; j < MAX_SQR; j++) {
			for (int k = j; k < MAX_SQR; k++) {
				for (int l = k; l < MAX_SQR; l++) {
					res = sqrNum[i] + sqrNum[j] + sqrNum[k] + sqrNum[l];
					if (res > MAX_VALUE) break;
					else
						result[res]++;
				}
			}
		}
	}
	int num;
	for (int i = 0; i < 256; i++) {
		scanf("%d", &num);
		if (num == 0)
			break;
		else
			printf("%d\n", result[num]);
	}

	return 0;
}