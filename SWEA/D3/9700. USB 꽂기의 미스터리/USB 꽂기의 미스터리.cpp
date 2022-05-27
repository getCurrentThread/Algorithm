#include <iostream>

int main() {
	int Tcase;
	scanf("%d", &Tcase);
	for (int i = 1; i <= Tcase; i++) {
		double p, q;
		scanf("%lf %lf", &p, &q);

		double s1 = (1.-p)*q;
		double s2 = p*(1.-q)*q;
		if (s1 < s2) {
			printf("#%d YES\n", i);
		}
		else {
			printf("#%d NO\n", i);
		}
	}


	return 0;
}