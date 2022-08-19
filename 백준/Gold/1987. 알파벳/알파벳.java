import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pos {
		int x;
		int y;
		int flag;

		public Pos(int x, int y, int flag) {
			this.x = x;
			this.y = y;
			this.flag = flag;
		}

		@Override
		public int hashCode() {
			return (x + y * 20) + flag << 6;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Pos) {
				Pos o = (Pos) obj;
				return (this.x == o.x && this.y == o.y && this.flag == o.flag);
			}
			return false;
		}
	}

	static int R, C;
	static char[][] map;

	static int ans;

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		Pos node = new Pos(0, 0, 1 << (map[0][0] - 'A'));
		q.add(node);
		while (!q.isEmpty() && ans < 26) {
			int qSize = q.size();
			while (qSize-- > 0) {
				node = q.poll();
				for (int i = 0; i < 4; i++) {
					int cx = node.x + dx[i];
					int cy = node.y + dy[i];
					if (0 <= cx && 0 <= cy && cx < R && cy < C) {
						if ((node.flag & (1 << (map[cx][cy] - 'A'))) == 0) {
							q.add(new Pos(cx, cy, node.flag | (1 << (map[cx][cy] - 'A'))));
						}
					}
				}
			}
			++ans;
			q = new LinkedList<Pos>(new HashSet<Pos>(q));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String row = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = row.charAt(j);
			}
		}

		bfs();

		System.out.println(ans);
	}

}
