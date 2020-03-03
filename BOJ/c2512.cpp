#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
vector<int> city;

int temp;
int sumCityBudget(int limitBuget) {
	int sum = 0;
	for (int i = 0; i < city.size(); i++) {
		sum += (city[i] > limitBuget) ? limitBuget : city[i];
	}
	return sum;
}

int main() {

	scanf("%d", &n);
	city.resize(n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		city[i] = temp;
	}
	scanf("%d", &m);

	sort(city.begin(), city.end());

	int left = 0, right = city[city.size() - 1], mid = left + (right-left) / 2;
	while (left <= right) {
		int ans = sumCityBudget(mid);
		if (ans > m) {
			right = mid - 1; 
		}
		else {
			left = mid + 1;
		}
		mid = left + (right - left) / 2;
	}

	printf("%d", mid-1);

	return 0;
}