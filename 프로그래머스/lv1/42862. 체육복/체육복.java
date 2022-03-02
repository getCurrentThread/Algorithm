import java.util.Arrays;

	class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			int students[] = new int[n + 2];

			Arrays.fill(students, 1);
			for (int i : lost) {
				students[i] = 0;
			}

			for (int i : reserve) {
				++students[i];
			}

			return dfs(0, n - lost.length, students, lost);
		}

		private int dfs(int depth, int mx, int[] students, int[] lost) {
			if (lost.length == depth) { // 기저 조건
				return mx;
			}
			
			int rsult = mx;
			int idx = lost[depth]; // 체육복을 잃어버린 학생 번호
			if(students[idx] == 0) { // 잃어 버렸다면
				if(students[idx-1] == 2) { //왼쪽 학생이 여벌을 가지고 있는가
					--students[idx-1]; // 한장 빼고
					rsult = Math.max(rsult, dfs(depth+1, mx+1, students, lost));
					++students[idx-1];
				}
				if(students[idx+1] == 2) { //오른쪽 학생
					--students[idx+1];
					rsult = Math.max(rsult, dfs(depth+1, mx+1, students, lost));
					++students[idx+1];
				}
				// 못 빌렸을 때의 상황
				rsult = Math.max(rsult, dfs(depth+1, mx, students, lost));
			}else { // 여벌을 가지고 있었다면
				rsult = Math.max(rsult, dfs(depth+1, mx+1, students, lost));
			}
			return rsult;
		}
	}