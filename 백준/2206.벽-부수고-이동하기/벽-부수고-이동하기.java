import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x;
		int y;
		int mSec;
		int broken;

		public Pos(int x, int y, int mSec, int broken) {
			this.x = x;
			this.y = y;
			this.mSec = mSec;
			this.broken = broken;
		}

		public Pos(int x, int y, int mSec) {
			this.x = x;
			this.y = y;
			this.mSec = mSec;
		};

	}

	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static int ans;

	public static void bfs() {
		Queue<Pos> pq = new LinkedList<>();
		pq.offer(new Pos(0, 0, 1));
		visited[0][0][0] = true;

		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		while (!pq.isEmpty()) {
			Pos p = pq.poll();
			if (p.x == N - 1 && p.y == M - 1) {
				ans = p.mSec;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				if (0 <= cx && 0 <= cy && cx < N && cy < M) {
					if (!visited[cx][cy][p.broken]) {
						Pos temp = new Pos(cx, cy, p.mSec + 1, p.broken + (map[cx][cy] == '1' ? 1 : 0));
						if (temp.broken == 2)
							continue;
						pq.offer(temp);
						visited[temp.x][temp.y][temp.broken] = true;
					}
				}
			}
		}
		ans = -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String row = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j);
			}
		}

		bfs();

		System.out.println(ans);
	}
}
