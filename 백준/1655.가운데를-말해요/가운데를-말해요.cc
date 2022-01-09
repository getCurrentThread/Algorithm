#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, temp;
vector<int> v;



int main() {
	priority_queue<int> left;
	priority_queue<int, vector<int>, greater<int> > right;

	scanf("%d", &n);
	v.resize(n + 1);
	for (int i = 1; i < n+1; i++) {
		scanf("%d", &temp);
		v[i] = temp;
	}
	
	int mid = v[1];
	left.push(mid);
	printf("%d\n", v[1]);
	for (int i = 2; i < v.size(); i++) {
		if (mid < v[i]) { //왼쪽 삽입
			right.push(v[i]);
		}
		else {
			left.push(v[i]);
		}
		if (i % 2 == 0) { //짝수인 경우
			while (right.size() != left.size()) {
				if (right.size() < left.size()) {
					right.push(left.top()); left.pop();
				}
				else {
					left.push(right.top()); right.pop();
				}
			}
		}
		else { //홀수인 경우
			while (left.size() - right.size() != 1) {
				if (left.size() < right.size()) {
					left.push(right.top()); right.pop();
				}
				else {
					right.push(left.top()); left.pop();
				}
			}
		}
		mid = left.top();
		printf("%d\n", mid);
	}


	return 0;
}