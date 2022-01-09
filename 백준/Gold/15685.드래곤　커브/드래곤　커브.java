import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] map;

	static final int sqr[][] = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
	static List<Integer> dirs;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		map = new boolean[101][101];
		int x, y, d, g;
		for (int i = 0; i < N; i++) {
			dirs = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			if (x >= 0 && x <= 100 && y >= 0 && y <= 100) // 자신의 위치 체크
				map[y][x] = true;
			x += dx[d];
			y += dy[d];
			if (x >= 0 && x <= 100 && y >= 0 && y <= 100) // 0세대 위치 체크
				map[y][x] = true;
			dirs.add((d + 1) % 4);
			simulate(x, y, g);
		}

		int ans = 0;
		int cx, cy;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]) {
					int k = 0;
					for (; k < 3; k++) {
						cx = i + sqr[k][0];
						cy = j + sqr[k][1];
						if (cx < 0 || cy < 0 || cx > 100 || cy > 100 || map[cx][cy] == false)
							break;
					}
					if (k == 3)
						++ans;
				}
			}
		}
		System.out.println(ans);
	}

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	private static void simulate(int x, int y, int g) {
		if (g == 0)
			return; // 기저조건
		for (int i = dirs.size() - 1; i >= 0; --i) { // 위치 만큼 반복
			int dir = dirs.get(i);
			x += dx[dir];
			y += dy[dir];
			if (x >= 0 && x <= 100 && y >= 0 && y <= 100) { // 자신의 위치 체크
				map[y][x] = true;
			}
			dirs.add((dir + 1) % 4);
		}
		simulate(x, y, g - 1); // 재귀호출
	}
}