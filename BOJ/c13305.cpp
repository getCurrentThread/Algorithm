#include <iostream>
#include <vector>
#include <queue>

using namespace std;
typedef long long int64;

int n, temp;
int64 ans;

vector<int> city;
vector<int> road;
priority_queue<int, vector<int>, greater<int> > pq;

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n - 1; i++) {
		scanf("%d", &temp);
		road.push_back(temp);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		city.push_back(temp);
	}

	for (int i = 0; i < n - 1; i++) {
		pq.push(city[i]);
		ans += (int64)pq.top() * road[i];
	}

	printf("%lld", ans);
	return 0;
}