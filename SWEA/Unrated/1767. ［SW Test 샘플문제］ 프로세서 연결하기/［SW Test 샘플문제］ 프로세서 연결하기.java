import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int mxCore, mnWire;
	static int map[][];
	static List<Pos> list;
	static int lSize;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static final int dx[] = { 0, 0, 1, -1 };
	static final int dy[] = { 1, -1, 0, 0 };

	public static void dfs(int depth, int cnt, int length) {
		if (depth == lSize) {
			// 모든 탐색을 완료했으므로 조건 체크
			if (mxCore < cnt) {
				mxCore = cnt;
				mnWire = length;
			} else if (mxCore == cnt) {
				mnWire = Math.min(mnWire, length);
			}
			return;
		}
		Pos pos = list.get(depth);

		for (int i = 0; i < 4; i++) {
			if (check(pos.x, pos.y, i)) {
				int len = setWire(pos.x, pos.y, i, 2);
				dfs(depth + 1, cnt + 1, length + len);
				setWire(pos.x, pos.y, i, 0);
			}
		}
		dfs(depth + 1, cnt, length);
	}

	public static boolean check(int x, int y, int dir) {
		x += dx[dir];
		y += dy[dir];
		while (0 <= x && 0 <= y && x < N && y < N) {
			if (map[x][y] != 0) {
				return false;
			}
			x += dx[dir];
			y += dy[dir];
		}
		return true;
	}

	public static int setWire(int x, int y, int dir, int color) {
		x += dx[dir];
		y += dy[dir];

		int cnt = 0;
		while (0 <= x && 0 <= y && x < N && y < N) {
			map[x][y] = color;
			cnt++;
			x += dx[dir];
			y += dy[dir];
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			mxCore = mnWire = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (map[i][j] == 1) {
						list.add(new Pos(i, j));
					}
				}
			}
			lSize = list.size();
			dfs(0, 0, 0);
			out.append('#').append(t).append(' ').append(mnWire).append('\n');
		}
		System.out.print(out);
	}
}
