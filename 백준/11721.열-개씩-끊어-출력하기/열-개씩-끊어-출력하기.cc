#include <iostream>
#include <cstring>

using namespace std;

int main() {
	char str[101];
	fgets(str, 101, stdin);
	
	int length = strlen(str);

	int i, cnt = 0;
	while(cnt < length){
		for (i = cnt; i < length && i - cnt < 10; i++) {
			putchar(str[i]);
		}
		cnt = i;
		puts("");
	}

	return 0;
}