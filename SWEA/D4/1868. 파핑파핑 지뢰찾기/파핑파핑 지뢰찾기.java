import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int Tcase;

	static int N;
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		Tcase = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= Tcase; t++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String row = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = row.charAt(j);
				}
			}

			int ans = simulation();
			out.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(out);
	}

	static final int dx[] = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static final int dy[] = { 1, 0, -1, 1, -1, 1, 0, -1 };

	private static int simulation() {
		int ans = 0;
		int[][] iMap = new int[N][N];

		// 정수 맵에 지뢰맵 범위 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '*') {
					iMap[i][j] = -10; // 지뢰 위치는 제외하기 위해 큰 음수값 대입
					for (int k = 0; k < 8; k++) {
						int cx = i + dx[k];
						int cy = j + dy[k];
						if (cx < 0 || cy < 0 || cx >= N || cy >= N)
							continue;
						++iMap[cx][cy];
					}
				}
			}
		}

		boolean visited[][] = new boolean[N][N];
		// 0에 해당하는 영역 flood-fill.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && iMap[i][j] == 0) {
					floodFill(i, j, iMap, visited); 
					++ans; //카운트 증가
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(iMap[i][j] > 0) { // 0보다 큰 경우에는 아직 선택되지 않은 영역이므로
					++ans;
				}
			}
		}

		return ans;
	}

	private static void floodFill(int x, int y, int[][] iMap, boolean[][] visited) {
		visited[x][y] = true;
		if (iMap[x][y] == 0) { // 값이 0 일 때에만 8방향 추가 지우기
			for (int i = 0; i < 8; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if (cx < 0 || cy < 0 || cx >= N || cy >= N || visited[cx][cy])
					continue;
				floodFill(cx, cy, iMap, visited);
			}
		}
		iMap[x][y] = -1; // 해당 영역 지우기
	}
}
