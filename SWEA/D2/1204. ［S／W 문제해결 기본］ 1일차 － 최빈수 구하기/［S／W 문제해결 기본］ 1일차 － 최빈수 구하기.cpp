#include<iostream>
#include<cstdlib>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	//freopen("input.txt", "r", stdin);
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> test_case;

		int score[101];
		for (int i = 0; i <= 100; i++) {
			score[i] = 0;
		}

		int src;
		for (int i = 0; i < 1000; i++) {
			scanf("%d", &src);
			++score[src];
		}
		
		int mx = 0;
		for (int i = 100; i >= 0; --i) {
			if (mx < score[i]) {
				mx = score[i];
				src = i;
			}
		}
		
		printf("#%d %d\n", test_case, src);
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}