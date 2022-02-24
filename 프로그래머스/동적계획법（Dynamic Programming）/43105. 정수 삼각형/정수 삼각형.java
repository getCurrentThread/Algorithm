class Solution {
		public int solution(int[][] triangle) {
			int dp[] = new int[triangle.length];
			System.arraycopy(triangle[triangle.length - 1], 0, dp, 0, dp.length);
			for (int i = triangle.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					dp[j] = triangle[i-1][j] + Math.max(dp[j], dp[j + 1]);
				}
			}
			
			return dp[0];
		}
	}