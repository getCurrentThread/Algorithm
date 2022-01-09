#include <iostream>
#include <stack>
#include <queue>

using namespace std;

queue<char> q;
stack<int> s;

int main() {

	int cnt;
	int stack = 0;
	int temp;
	queue<int> data;
	
	scanf("%d", &cnt);

	for (int i = 0; i < cnt; i++)
	{
		scanf("%d", &temp);
		data.push(temp);
	}


	int i = 1;

	int top = data.front();
	data.pop();

	while (i <= (cnt+1))
	{
		if(s.empty() || s.top() < top){
			s.push(i);
			q.push('+');
			i++;
		}
		else if(s.top() > top){
			break;
		}
		else {
			s.pop();
			q.push('-');
			stack++;

			if (data.empty()) {
				break;
			}
			else {
				top = data.front();
				data.pop();
			}
		}
	}

	if (stack != cnt) {
		printf("NO");
		return 0;
	}

	while (!q.empty()) {
		printf("%c\n", q.front());
		q.pop();
	}

	return 0;
}