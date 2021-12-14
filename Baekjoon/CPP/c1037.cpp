#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	int k, temp;
	vector<int> v;
	
	scanf("%d", &k);
	for (int i = 0; i < k; i++) {
		scanf("%d", &temp);
		v.push_back(temp);
	}
	sort(v.begin(), v.end());

	printf("%d", v.front() * v.back());

	return 0;
}
