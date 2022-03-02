import java.util.Arrays;

class Solution {
		public int solution(int[][] routes) {
			int cnt = 1;
			Arrays.sort(routes, (a, b) -> a[0] - b[0]);

			int nd = routes[0][1];

			for (int i = 0; i < routes.length; i++) {
				if (nd < routes[i][0]) { // nd < st : 범위를 벗어난 경우
					nd = routes[i][1];
					cnt++;		//카운트 추가
					continue;
				}
				nd = Math.min(nd, routes[i][1]); // nd 갱신
			}
			return cnt;
		}
	}