#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

#define MAX 100000

using namespace std;

int n;
vector<pair<int, int> > rv; 
unsigned int time;
int ans;

int main() {

	scanf("%d", &n);
	int st, nd;
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &st, &nd);
		rv.push_back({ nd, st });
	}

	sort(rv.begin(), rv.end());

	time = 0;
	
	for (int i = 0; i < rv.size(); i++) {
		if (time <= rv[i].second) {
			time = rv[i].first;
			ans++;
		}
	}

	printf("%d", ans);

	return 0;
}