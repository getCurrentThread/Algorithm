#include<iostream>
#include<vector>
#include<algorithm>

#define MAX 1000

using namespace std;

int n, w;

vector<pair<int, int> > v;

typedef struct _node {
	pair<int, int> one, two;//경찰차 1, 2의 현 좌표
	int dst;//이동거리
}Node;

Node dp[MAX + 1][3];

int distance(const pair<int, int>& a, const pair<int, int>& b) {
	return abs(a.first - b.first) + abs(a.second - b.second);
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;
	cin >> w;

	int x, y;
	for (int i = 0; i < w; i++) {
		cin >> x >> y;
		v.push_back({ x, y });
	}

	dp[0][0] = { {1,1}, {n,n}, 0 };
	dp[0][1] = { v[0], {n,n}, distance({1,1}, v[0]) };
	dp[0][2] = { {1,1}, v[0], distance({n,n}, v[0]) };
	for (int i = 1; i < w; i++) {
		dp[i][0] = (dp[i - 1][1].dst < dp[i - 1][2].dst) ? dp[i - 1][1] : dp[i - 1][2]; //이전 위치 이동에서 최선의 이동의 경우를 가져옴
		dp[i][1] = { v[i], dp[i][0].two, distance(v[i], dp[i][0].one) + dp[i][0].dst }; //1번 경찰차가 해당 위치로 갈 때
		dp[i][2] = { dp[i][0].one, v[i], distance(v[i], dp[i][0].two) + dp[i][0].dst }; //2번 경찰차가 해당 위치로 갈 때
	}

	printf("%d\n", min(dp[w - 1][1].dst, dp[w - 1][2].dst));
	for (int i = 0; i < w; i++) {
		if (dp[i][1].dst < dp[i][2].dst)	puts("1");
		else								puts("2");
	}

	return 0;
}
