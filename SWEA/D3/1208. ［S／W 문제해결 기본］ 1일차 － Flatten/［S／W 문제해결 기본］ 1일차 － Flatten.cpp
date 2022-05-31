#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;

	//freopen("input.txt", "r", stdin);


	for (test_case = 1; test_case <= 10; ++test_case)
	{
		int n;
		scanf("%d", &n);
		
		vector<int> v(100);

		int tmp;
		for (int i = 0; i < 100; i++) {
			scanf("%d", &tmp);
			v[i] = tmp;
		}
		sort(v.begin(), v.end());
		
		for (int i = 0; i < n; i++) {
			++v[0]; --v[99];
			sort(v.begin(), v.end());
		}

		printf("#%d %d\n", test_case, v[99] - v[0]);
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}