class Solution {
		static final int dx[] = { 0, 0, 1, -1 };
		static final int dy[] = { 1, -1, 0, 0 };

		public int[] solution(int m, int n, int[][] picture) {
			int numberOfArea = 0;
			int maxSizeOfOneArea = 0;
			long map[][] = new long[m][n];
			for(int i =0; i < m; i++) {
				for(int j =0; j < n; j++) {
					map[i][j] = picture[i][j];
				}
			}

			int tmp;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != 0) {
						maxSizeOfOneArea = Math.max(maxSizeOfOneArea
								, dfs(map, m, n, i, j, map[i][j]));
						numberOfArea++;
					}
				}
			}

			int[] answer = new int[2];
			answer[0] = numberOfArea;
			answer[1] = maxSizeOfOneArea;
			return answer;
		}

		private int dfs(final long[][] map, final int M, final int N, int x, int y, final long COLOR) {
			int count = 1;
			map[x][y] = 0;
			int cx, cy;
			for (int i = 0; i < 4; i++) {
				cx = x + dx[i];
				cy = y + dy[i];
				if (cx < 0 || cy < 0 || cx >= M || cy >= N || map[cx][cy] != COLOR)
					continue;
				count += dfs(map, M, N, cx, cy, COLOR);
			}
			return count;
		}
	}