/*
http://wookje.dance/2019/01/22/boj-2618/
https://jason9319.tistory.com/224
풀이 활용.
dp[i][j] : 경찰차1이 i번째 사건, 경찰차2가 j번째 사건 위치에 있을 때의 최소값
max(i,j) : 현재 처리하고 있는 사건
k = max(i,j)+1 : 다음 처리해야할 사건
dp[k][j] = dp[k-1][j] + dst(k, k-1) : 경찰차1이 k번째 사건을 처리하면...
dp[i][j] = dp[i][k-1] + dst(k, k-1) : 경찰자2가 k번째 사건을 처리하면...
*/
#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 1000
#define INF 2100000000

using namespace std;

int n, w; //n: 도로 개수, w: 사건 개수
vector<pair<int, int> > v; //사건들
vector<pair<int, int> > car1, car2; //i번째 사건을 처리하고 있는 차량 위치.
int memo[MAX + 2][MAX + 2];
int back[MAX + 2];

int distance(const pair<int, int>& a, const pair<int, int>& b) {
    return abs(a.first - b.first) + abs(a.second - b.second);
}

int dp(int i, int j) {
    if (memo[i][j]) return memo[i][j]; // 메모된 값이 있는 경우 반환
    //if (i != 0 && j != 0 && i == j) return memo[i][j] = INF; // 같은 사건을 처리하는 일은 없음
    if (i == w || j == w) return 0; // 두 차량 중에 마지막 사건에 도달한 경우.
    int k = max(i, j) + 1; //다음 사건
    /*
    return memo[i][j] = min(dp(k, j) + distance(car1[i], car1[k]), //차량1이 i좌표에서 k좌표로 이동
                            dp(i, k) + distance(car2[j], car2[k]));//차량2가 j좌표에서 k좌표로 이동
    */
    int first  = dp(k, j) + distance(car1[i], car1[k]);
    int second = dp(i, k) + distance(car2[j], car2[k]);
    if (first < second) {
        back[k] = 1;
        return memo[i][j] = first;
    }
    else {
        back[k] = 2;
        return memo[i][j] = second;
    }
}

int main() {

    scanf("%d", &n);
    scanf("%d", &w);

    int x, y;
    v.push_back({ INF, INF }); //인덱스를 1부터 시작하기 위한 가짜 좌표.
    for (int i = 0; i < w; i++) {
        scanf("%d%d", &x, &y);
        v.push_back({ x, y });
    }
    //메모리가 아깝지만... dp함수에 쓸모없는 조건문 몇개 없앨 수 있다면야...
    car1 = car2 = v;
    car1[0] = { 1,1 };
    car2[0] = { n,n };

    for (int i = 1; i <= w; i++) {
        memo[i][i] = INF;
    }
    int mn = dp(0, 0);
    printf("%d\n", mn);

    for (int i = 1; i <= w; i++) {
        printf("%d\n", back[i]);
    }

    return 0;
}