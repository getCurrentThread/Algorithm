#include <stdio.h>
 
void average() {
	int num, people, score, i;
	int st[1000];
	int int_people, sum;
	scanf("%d", &num);
 
	while(--num >= 0) {
		scanf("%d", &people);
		sum = 0;
 
		for(i = 0; i <1000; i++)
        	st[i] = -1;
		for (int j = 0; j < people; j++) {
			scanf("%d", &score);
			sum += score;
			st[j] = score;
		}
		i = 0;
		sum /= people; int_people = 0;
 
		while(st[i] >= 0) {
			if (st[i] > sum)
				int_people++;
			i++;
		}
		printf("%.3lf%%\n", ((double)int_people / people) * 100);
	}
}
 
main() {
	average();
}