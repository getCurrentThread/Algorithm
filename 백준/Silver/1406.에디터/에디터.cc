#include <iostream>
#include <list>
#include <string>
#include <sstream>

#define MAX 100000

using namespace std;

list<char> lt;


int main() {
	int cnt;
	string str;
	list<char>::iterator it;

	cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);

	cin >> str;

	for (int i = 0; i < str.length(); i++)
	{
		lt.push_back(str[i]);
	}
	it = lt.end();

	cin >> cnt;
	cin.ignore();
	for (int i = 0; i < cnt; i++)
	{
		string token;

		getline(cin, str);
		stringstream ss(str);
		getline(ss, token, ' ');

		if (token == "L") {
			if (it != lt.begin()) {
				it--;
			}
		}
		else if (token == "D") {
			if (it != lt.end()) {
				it++;
			}
		}
		else if (token == "B") {
			if (it != lt.begin()) {
				it = lt.erase(--it);
			}
		}
		else if (token == "P") {
			getline(ss, token);
			lt.insert(it, token[0]);
		}
	}

	for (list<char>::iterator it = lt.begin(); it != lt.end(); it++)
	{
		cout << *it;
	}

	return 0;
}