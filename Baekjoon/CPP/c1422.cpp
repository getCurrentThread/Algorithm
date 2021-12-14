#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int k, n, temp;

bool cmp(const string& a, const string& b) {
	return a + b > b + a;
}

vector<string> sv;

int main() {
	scanf("%d %d", &k, &n);

	int mx = 0;
	for (int i = 0; i < k; i++) {
		scanf("%d", &temp);
		mx = max(mx, temp);
		sv.push_back(to_string(temp));
	}
	for (int i = n - k; i > 0; i--) {
		sv.push_back(to_string(mx));
	}

	sort(sv.begin(), sv.end(), cmp);
	
	for (int i = 0; i < sv.size(); i++) {
		printf("%s", sv[i].c_str());
	}

	return 0;
}