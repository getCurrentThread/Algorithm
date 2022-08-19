import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		simulation();

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static List<Pos> list;

	static final int dx[] = { 1, -1, 0, 0 };
	static final int dy[] = { 0, 0, 1, -1 };

	private static void simulation() {
		list = new ArrayList<Pos>();
		int[][] initMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switch (map[i][j]) {
				case 0: // 공기인 경우
					initMap[i][j] = Integer.MAX_VALUE;
					break;
				case 1: // 벽인 경우
					initMap[i][j] = -1;
					break;
				case 2: // 바이러스 인 경우
					initMap[i][j] = 0;
					list.add(new Pos(i, j));
					break;
				}
			}
		}
		dfs(initMap, 0, 0);
	}

	private static void dfs(int[][] map, int depth, int nxt) {
		if (depth == M) {
			// check
			int mx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] < 0) { // 벽이 있는 곳은 모두 -1 처리하였으므로
						continue;
					} else if (map[i][j] == Integer.MAX_VALUE) { // 방문하지 않은 영역이 있다면
						return;
					} else {
						mx = Math.max(mx, map[i][j]);
					}
				}
			}
			ans = Math.min(ans, mx);
			return;
		}
		int[][] cMap = new int[N][N];

		for (; nxt < list.size(); nxt++) {
			// init...
			copyMap(map, cMap);

			// run BFS...
			Pos pos;
			Queue<Pos> q = new LinkedList<Pos>();
			boolean visited[][] = new boolean[N][N];

			q.add(pos = list.get(nxt));
			visited[pos.x][pos.y] = true;

			int cx, cy, nxtVal;
			int step = 1;
			while (!q.isEmpty()) {
				int qSize = q.size();
				while (qSize-- > 0) {
					pos = q.poll();
					nxtVal = cMap[pos.x][pos.y] + 1;
					for (int i = 0; i < 4; i++) {
						cx = pos.x + dx[i];
						cy = pos.y + dy[i];
						if (cx < 0 || cy < 0 || cx >= N || cy >= N || visited[cx][cy] || cMap[cx][cy] == -1)
							continue;
						if(cMap[cx][cy] > step)
							cMap[cx][cy] = step;
						q.add(new Pos(cx, cy));
						visited[cx][cy] = true;
					}
				}
				++step;
			}

			// next..
			dfs(cMap, depth + 1, nxt + 1);
		}
	}

	private static void copyMap(int[][] src, int[][] dest) {
		for (int i = 0; i < N; i++) {
			System.arraycopy(src[i], 0, dest[i], 0, N);
		}
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
