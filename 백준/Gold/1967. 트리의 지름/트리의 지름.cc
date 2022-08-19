#include <iostream>
#include <algorithm>
#include <vector>

#define MAX 10000

using namespace std;

int n;
int mx;

vector<vector<pair<int, int>>> v; //graph

int dfs(int node) {
	int siz = v[node].size();
	if (siz == 0) {
		return 0;
	}
	else if(siz == 1) {
		int rsult = v[node][0].second + dfs(v[node][0].first);
		mx = max(mx, rsult);
		return rsult;
	}
	else {
		vector<int> vm(siz);
		for (int i = 0; i < vm.size(); i++) {
			vm[i] = v[node][i].second + dfs(v[node][i].first);
		}
		sort(vm.begin(), vm.end());
		mx = max(mx, vm[siz - 1] + vm[siz - 2]);
		return	vm[siz - 1];
	}
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);

	cin >> n;
	v.resize(n + 1);

	int parent, child, weight;
	for (int i = 0; i < n-1; i++){
		cin >> parent >> child >> weight;
		v[parent].push_back({ child, weight });
	}
	dfs(1);
	cout << mx;
	return 0;
}