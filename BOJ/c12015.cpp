#include <iostream>
#include <algorithm>
#include <vector>
#include <limits>

#define INT_MAX numeric_limits<int>::max()

using namespace std;

int n, temp;
vector<int> v;

int main() {
	scanf("%d", &n);

	v.push_back(INT_MAX);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		if (temp > v.back()) {
			v.push_back(temp);
		}
		else { // temp < max_value
			auto it = lower_bound(v.begin(), v.end(), temp);
			*it = temp;
		}
	}
	printf("%d", v.size());
	
	return 0;
}