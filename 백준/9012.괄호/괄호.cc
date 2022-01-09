#include <iostream>
#include <stack>

using namespace std;

bool isValidPS(char str[]) {
	stack<char> st;
	for (char* it = str; *it != '\0'; it++)
	{
		if (*it == '(') {
			st.push('(');
		}
		else { //')'
			if (st.empty()) {
				return false;
			}
			else {
				st.pop();
			}
		}
	}
	return st.empty();
}

int main() {
	
	int cnt;
	char str[51];

	scanf("%d", &cnt);
	for (int i = 0; i < cnt; i++)
	{
		scanf("%s", str);
		if (isValidPS(str)) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
	}
	return 0;
}