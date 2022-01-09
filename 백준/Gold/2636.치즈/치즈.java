import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int map[][];

	static final int dx[] = { 0, 0, -1, 1 };
	static final int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int before = -1;
		int time = 0;
		while (true) {
			// BFS
			Queue<Pos> q = new LinkedList<Pos>();

			q.add(new Pos(0, 0));
			boolean visited[][] = new boolean[M][N];
			while (!q.isEmpty()) {
				Pos pos = q.poll();
				if (map[pos.x][pos.y] == 1) { // 치즈 영역인 경우
					map[pos.x][pos.y] = 2; // 산소에 닿아있는 치즈로 표기
					continue;
				}
				for (int i = 0; i < 4; i++) {
					int cx = pos.x + dx[i];
					int cy = pos.y + dy[i];
					if (cx < 0 || cy < 0 || cx >= M || cy >= N || visited[cx][cy])
						continue;
					visited[cx][cy] = true; // 방문 표시
					q.add(new Pos(cx, cy));
				}
			}

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = false;
					if (map[i][j] == 2) { // 산소와 닿아있는 치즈 카운트
						cnt++;
						map[i][j] = 0; // 산화
					}
				}
			}

			if (cnt == 0) {
				break;
			} else {
				time++;
				before = cnt;
			}
		}
		System.out.println(time);
		System.out.println(before);
	}

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
