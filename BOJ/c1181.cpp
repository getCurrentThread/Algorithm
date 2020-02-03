#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

bool compare(string& a, string& b) {
	if (a.length() < b.length()) {
		return true;
	}
	else if (a.length() > b.length()) {
		return false;
	}
	else {
		return a < b;
	}
}

int main(void) {
	int n;
	string v[20000];
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	sort(v, v + n, compare);
	for (int i = 0; i < n; i++) {
		if (i > 0 && v[i] == v[i - 1]) {
			continue;
		}
		else {
			cout << v[i] << endl;
		}
	}
	return 0;
}