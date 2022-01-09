#include <iostream>	
#include <cstring>

using namespace std;

int arr[1001];
bool visited[1001];

int main() {
	cin.tie(0);
	ios::sync_with_stdio(0);

	int Tcase;
	cin >> Tcase;
	for (int t = 1; t <= Tcase; t++) {
		int N;
		cin >> N;
		memset(visited, false, sizeof(bool) * (N + 1));
		
		
		for (int i = 1; i <= N; i++) {
			cin >> arr[i];
		}

		int cycleGrp = 0;
		for (int i = 1; i <= N; i++) {
			int nxt,start;
			if (visited[i]) continue;
			start = nxt = i;
			do {
				visited[nxt] = true;
				nxt = arr[nxt];
			} while (start != nxt);
			cycleGrp++;
		}

		cout << cycleGrp << endl;
	}

	return 0;
}