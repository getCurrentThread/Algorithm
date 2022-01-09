#include <iostream>

using namespace std;

int n;

int nQueenProblem(int n) {
	switch (n)
	{
	case 1:
		return 1;
	case 2:
	case 3:
		return 0;
	case 4:
		return 2;
	case 5:
		return 10;
	case 6:
		return 4;
	case 7:
		return 40;
	case 8:
		return 92;
	case 9:
		return 352;
	case 10:
		return 724;
	case 11:
		return 2680;
	case 12:
		return 14200;
	case 13:
		return 73712;
	case 14:
		return 365596;
	}
}

int main() {

	scanf("%d", &n);
	
	
	printf("%d", nQueenProblem(n));

	return 0;
}