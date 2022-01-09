#include <iostream>

using namespace std;

int main() {
	int Tcase;
	scanf("%d", &Tcase);

	int cnt, ovs;
	double avg;
	int members[1000];
	for (int i = 0; i < Tcase; i++) {
		scanf("%d", &cnt);
		
		avg = 0.; ovs = 0;
		int tmp;
		for (int i = 0; i < cnt; i++) {
			scanf("%d", &tmp);
			members[i] = tmp;
			avg += tmp;
		}
		avg /= cnt;
		for (int i = 0; i < cnt; i++) {
			if (avg < members[i]) {
				ovs++;
			}
		}
		printf("%.3f%%\n", 100. * ovs / cnt);
	}


	return 0;
}