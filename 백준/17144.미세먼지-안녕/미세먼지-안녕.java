import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] map, tMap;
	static int start, end;

	static final int[] dy = { -1, 0, 1, 0 };
	static final int[] dx = { 0, 1, 0, -1 };

	static final int[] rdy = { 1, 0, -1, 0 };
	static final int[] rdx = { 0, 1, 0, -1 };

	private static void refreshAir(int[][] map, int upper, int lower) {
		int y, x;

		y = upper;
		x = 0;

		int i = 0;
		while (i < 4) {
			map[y][x] = map[y + dy[i]][x + dx[i]];
			y += dy[i];
			x += dx[i];
			if ((y == upper && (x == 0 || x == C - 1)) || (y == 0 && (x == 0 || x == C - 1))) {
				i++;
			}
		}

		y = lower;
		x = 0;

		i = 0;
		while (i < 4) {
			map[y][x] = map[y + rdy[i]][x + rdx[i]];
			y += rdy[i];
			x += rdx[i];
			if ((y == lower && (x == 0 || x == C - 1)) || (y == R - 1 && (x == 0 || x == C - 1))) {
				i++;
			}
		}

		map[upper][1] = map[lower][1] = 0;
		map[upper][0] = map[lower][0] = -1;
	}

	private static void simulation() {

		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < R; i++)
				Arrays.fill(tMap[i], 0);

			int tmp;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if ((tmp = map[i][j]) != 0 && tmp != -1) {
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int cy = i + dy[k];
							int cx = j + dx[k];
							if (0 <= cx && 0 <= cy && cx < C && cy < R && map[cy][cx] != -1) {
								tMap[cy][cx] += tmp / 5;
								cnt++;
							}
						}
						tMap[i][j] += map[i][j] - (tmp / 5) * cnt;
					}
				}
			}
			
			tMap[start][0] = tMap[end][0] = -1;
			for (int i = 0; i < R; i++)
				System.arraycopy(tMap[i], 0, map[i], 0, C);
			refreshAir(map, start, end);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		tMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 공기 청정기 위치
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				start = i;
				end = i + 1;
				break;
			}
		}

		simulation();

		int ans = 2; // 공기청정기가 -1 값으로 되어 있으므로
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

}
