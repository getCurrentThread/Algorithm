#include <iostream>
#include <bitset>

using namespace std;

int num;
int temp;
bitset<20000000ul> bits;

int main() {

	scanf("%d", &num);

	for (int i = 0; i < num; i++)
	{
		scanf("%d", &temp);
		bits.set(10000000+temp);
	}

	scanf("%d", &num);

	for (int i = 0; i < num; i++)
	{
		scanf("%d", &temp);
		if (bits[10000000 + temp])
		{
			printf("%d ", 1);
		}
		else 
		{
			printf("%d ", 0);
		}
	}

	return 0;
}