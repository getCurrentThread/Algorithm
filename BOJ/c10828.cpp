#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {

	int cnt;
	string cmd;
	int num;
	stack<int> a;

	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	cin >> cnt;

	for (int i = 0; i < cnt; i++)
	{
		cin >> cmd;
		
		if (cmd == "push"){
			cin >> num;
			a.push(num);
		}
		else if (cmd == "pop"){
			if (a.empty()) {
				cout << -1 << "\n";
				continue;
			}
			int temp = a.top();
			a.pop();
			cout << temp << "\n";
		}
		else if (cmd == "size") {
			cout << a.size() << "\n";
		}
		else if (cmd == "empty") {
			cout << a.empty() << "\n";
		}
		else if (cmd == "top") {
			if (a.empty()) {
				cout << -1 << "\n";
				continue;
			}
			cout << a.top() << "\n";
		}
	}

	return 0;
}