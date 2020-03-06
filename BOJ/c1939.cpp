#include <iostream>
#include <vector>
//#include <queue>
#include <bitset>
#include <algorithm>
//#include <limits>

#define MAX 1000000

using namespace std;

int n, m, mx;
int st, nd;
int left, right, mid;

vector<vector<pair<int, int> > > v; // (next_city, weight)
bitset<MAX + 1> visited;

//queue<pair<int, int> > q;// (next_city, weight)
//int visited[MAX + 1];//지나간 최대 적재량

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.first == b.first)
		return a.second > b.second;	//적재량 기준 내림차순
	return a.first < b.first;		//도시 기준 오름차순
}
bool cmpWeight(const pair<int, int>& a, const pair<int, int>& b) {
	return a.second < b.second; //적재량 기준 오름차순
}
bool isPossibleDFS(int x) {
	for(int i = 0; i  < )
}

int main() {
	scanf("%d%d", &n, &m);
	v.resize(n + 1);

	int a, b, c;
	for (int i = 0; i < m; i++) {
		scanf("%d%d%d", &a, &b, &c);
		v[a].push_back({ b, c });
		v[b].push_back({ a, c });
	}
	scanf("%d%d", &st, &nd);

	for (int i = 0; i < v.size(); i++) { //두 도시를 연결하는 최대 적재량 다리만 남김
		sort(v[i].begin(), v[i].end(), cmp);
		v[i].resize(unique(v[i].begin(), v[i].end()) - v[i].begin());
	}

	//solve: bi-search
	for (int i = 0; i < v.size(); i++) {
		sort(v[i].begin(), v[i].end(), cmpWeight);//적재량 기준으로 오름차순
	}

	left = 0, right = 1000000000, mid = left + (right - left) / 2;
	while (left <= right) {
		
		if (isPossibleDFS(mid)) {//성공한 경우 케이스를 키워서, 실패한 경우는 케이스를 줄여서
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
		mid = left + (right - left) / 2;
	}
	mx = mid - 1;
	/*
	//solve: BFS -> failed(OutOfMemory)
	visited[st] = numeric_limits<int>::max(); //st != nd 이므로 다음과 같이 활용.
	for (int i = 0; i < v[st].size(); i++) {
		q.push(v[st][i]);
		visited[v[st][i].first] = max(visited[v[st][i].first], v[st][i].second);
	}

	while (!q.empty()) {
		auto current = q.front(); q.pop(); // (cur_city, weight)
		if (visited[current.first] > current.second) continue;
		visited[current.first] = current.second;
		if (current.first == nd) continue; //끝지점일 경우 종료.
		for (int i = 0; i < v[current.first].size(); i++) {
			auto next = v[current.first][i]; // (next_city, ...)
			int nextWeight = min(current.second, next.second);
			if (nextWeight < visited[next.first]) continue;
			q.push({next.first, nextWeight});
		}
	}

	mx = visited[nd];
	*/
	printf("%d", mx);

	return 0;
}