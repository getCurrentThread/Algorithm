#include <iostream>

using namespace std;

int pv[10];
bool visited[10000000];
int ans;

int A, P;

int bfs(int cnt, int num) {
	int tmp = num;
	int sum = 0;

	if (visited[num]) return num;
	visited[num] = true;

	while (tmp) {
		sum += pv[tmp % 10];
		tmp /= 10;
	}
	int rslt = bfs(cnt + 1, sum);
	if (rslt == num) {
		ans = cnt;
	}
	return rslt;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	cin >> A >> P;

	for (int i = 1; i < 10; i++) {
		pv[i] = i;
	}
	for(int i = 1; i < P; i++){
		for (int i = 1; i < 10; i++) {
			pv[i] *= i;
		}
	}
	
	bfs(0, A);
	cout << ans << endl;

	return 0;
}