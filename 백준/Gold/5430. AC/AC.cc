#include <iostream>
#include <queue>
#include <deque>

#define FFLUSH while(( temp = getchar() ) != EOF && temp != '\n');
using namespace std;

char p[100001];

int main() {

	int Tcase;
	int eleNum;
	int temp;

	scanf("%d", &Tcase);

	for (int i = 0; i < Tcase; i++) {

		deque<int> dq;

		scanf("%s", p);
		scanf("%d", &eleNum);

		FFLUSH;
		for (int i = 0; i < eleNum; i++)
		{
			scanf("%*c%d", &temp);
			dq.push_back(temp);
		}
		FFLUSH;

		bool reverseFlag = false;
		bool errOccured = false;
		for (int i = 0; p[i] != '\0'; i++)
		{
			switch (p[i])
			{
			case 'R':
				reverseFlag = !reverseFlag;
				break;
			case 'D':
				if (dq.empty()) {
					errOccured = true;
					break;
				}
				if (reverseFlag) {
					dq.pop_back();
				}
				else {
					dq.pop_front();
				}
				eleNum--;
				break;
			}
		}

		if(errOccured){
			printf("error\n");
			continue;
		}
		if (reverseFlag) {
			printf("[");
			for (int i = 0; i < eleNum; i++) {
				printf("%d", dq.back()); dq.pop_back();
				if (i < (eleNum - 1))
					putchar(',');
			}
			printf("]\n");
		}
		else{
			printf("[");
			for (int i = 0; i < eleNum; i++) {
				printf("%d", dq.front()); dq.pop_front();
				if (i < (eleNum - 1))
					putchar(',');
			}
			printf("]\n");
		}
	}


	return 0;
}