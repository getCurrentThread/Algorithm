#include <iostream>
#include <deque>

using namespace std;

int main() {

	int num;
	int element;
	string cmd;
	deque<int> q;

	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	cin >> num;

	for (int i = 0; i < num; i++)
	{
		cin >> cmd;
		if (cmd == "push_front") {
			cin >> element;
			q.push_front(element);
		}
		else if (cmd == "push_back") {
			cin >> element;
			q.push_back(element);
		}
		else if (cmd == "pop_front") {
			if (q.empty()) {
				cout << -1 << endl;
				continue;
			}
			int temp = q.front();
			q.pop_front();
			cout << temp << endl;
		}
		else if (cmd == "pop_back") {
			if (q.empty()) {
				cout << -1 << endl;
				continue;
			}
			int temp = q.back();
			q.pop_back();
			cout << temp << endl;
		}
		else if (cmd == "size") {
			cout << q.size() << endl;
		}
		else if (cmd == "empty") {
			cout << ((q.empty()) ? 1 : 0) << endl;
		}
		else if (cmd == "front") {
			if (q.empty()) {
				cout << -1 << endl;
				continue;
			}
			cout << q.front() << endl;
		}
		else if (cmd == "back") {
			if (q.empty()) {
				cout << -1 << endl;
				continue;
			}
			cout << q.back() << endl;
		}
	}
	

	return 0;
}