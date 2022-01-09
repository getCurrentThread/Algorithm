#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

typedef struct _cmpASCStation {
    bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    }
}CmpASCStation;

int n, ans;
int l, p; // l: total_distance, p: left_oil
vector<pair<int, int> > station; // (distance, oil)
priority_queue<int> pq; // oil

int main() {
    scanf("%d", &n);

    int distance, oil;
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &distance, &oil);
        station.push_back({ distance, oil });
    }

    scanf("%d %d", &l, &p);

    sort(station.begin(), station.end());

    int i = 0;
    do {
        if (!pq.empty()) { // 주유
            p += pq.top(); pq.pop();
            ans++;
        }
        for (; i < station.size() && station[i].first <= p; i++) {
            pq.push(station[i].second);
            continue;
        }
    } while (p < l && !pq.empty());

    if (p < l)
        puts("-1");
    else
        printf("%d", ans);
    return 0;
}