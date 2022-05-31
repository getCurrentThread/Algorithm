#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N;
		cin >> N;

		int tmp;

		vector<pair<int, int> > v(N);
		for (int i = 0; i < N; i++) {
			scanf("%d", &tmp);
			v[i].first = tmp;
		}
		for (int i = 0; i < N; i++) {
			scanf("%d", &tmp);
			v[i].second = tmp;
		}

		sort(v.begin(), v.end());

		printf("#%d ", test_case);
		for(int i = 0; i < N-1; i++){

			double left = v[i].first, right = v[i + 1].first, mid = left + (right - left) / 2.;
			while (0.1e-11 < right - left) {
				double force = 0.;
				for (int i = 0; i < N; i++) {
					double d = (mid - v[i].first);
					force += (d>0.)? -v[i].second / (d * d) :v[i].second / (d * d);
				}
				if (force < 0.) {
					left = mid;
				}
				else {
					right = mid;
				}

				mid = left + (right - left) / 2.;
			}
			printf("%.10f ", mid);
		}
		puts("");
	}
	return 0;
}