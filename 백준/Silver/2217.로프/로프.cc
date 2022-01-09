#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;

int n;
vector<int> v;
int maximum;

int w;

int main() {

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &w);
		v.push_back(w);
	}

	sort(v.begin(), v.end(), greater<int>());

	for (int i = 0; i < v.size(); i++) {
		maximum = max(maximum, v[i] * (i + 1));
	}

	printf("%d", maximum);
    
	return 0;
}