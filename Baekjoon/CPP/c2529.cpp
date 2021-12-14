#include <iostream>
#include <vector>
#include <bitset>
#include <cassert>

using namespace std;

int k;
vector<char> v;
vector<int> btm, top;
bitset<10> visited;

char ch;
int temp;

bool bottomUpDFS(int n) {
	if (n == k + 1) {
		return true;
	}
	else if (n == 0) {
		for (int i = 0; i <= 9; i++) {
			btm[n] = i;
			visited[i] = true;
			if (bottomUpDFS(n + 1)) { return true; }
			visited[i] = false;
		}
	}
	else if(v[n - 1] == '<'){
		for (int i = btm[n - 1] + 1; i <= 9; i++) {
			if (visited[i]) continue;
			btm[n] = i;
			visited[i] = true;
			if (bottomUpDFS(n + 1)) { return true; }
			visited[i] = false;
		}
	}
	else { // '>'
		for (int i = 0; i <= btm[n - 1] - 1; i++) {
			if (visited[i]) continue;
			btm[n] = i;
			visited[i] = true;
			if (bottomUpDFS(n + 1)) { return true; }
			visited[i] = false;
		}
	}
	return false;
}

bool topDownDFS(int n) {
	if (n == k + 1) {
		return true;
	}
	else if (n == 0) {
		for (int i = 9; i >= 0; i--) {
			top[n] = i;
			visited[i] = true;
			if (topDownDFS(n + 1)) { return true; }
			visited[i] = false;
		}
	}
	else if (v[n - 1] == '<') {
		for (int i = 9; i >= top[n - 1] + 1; i--) {
			if (visited[i]) continue;
			top[n] = i;
			visited[i] = true;
			if (topDownDFS(n + 1)) { return true; }
			visited[i] = false;
		}
	}
	else { // '>'
		for (int i = top[n - 1] - 1; i >= 0; i--) {
			if (visited[i]) continue;
			top[n] = i;
			visited[i] = true;
			if (topDownDFS(n + 1)) { return true; }
			visited[i] = false;
		}
	}
	return false;
}

int main() {
	scanf("%d", &k);
	getchar();
	for (int i = 0; i < k; i++) {
		scanf("%c%*c", &ch);
		v.push_back(ch);
	}
	btm.resize(k + 1); top.resize(k + 1);
	
	bottomUpDFS(0); visited.reset();
	topDownDFS(0);

	for (int i = 0; i < top.size(); i++) {
		printf("%d", top[i]);
	}
	printf("\n");

	for (int i = 0; i < btm.size(); i++) {
		printf("%d", btm[i]);
	}

	return 0;
}