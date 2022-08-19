import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static public class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
	}

	static public class Fish {
		int x;
		int y;
		int size;

		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}

	static int[][] map;
	static int N;
	static Fish shark;
	static int feed;
	static int moveCnt;
	
	public static Pos chooseFish(Pos mn, Queue<Pos> q, int size) {
		while(--size >= 0) {
			Pos pos = q.poll();
			if(map[pos.x][pos.y] == 0 || map[pos.x][pos.y] >= shark.size) continue;
			if(mn.x > pos.x) {
				mn.x = pos.x;
				mn.y = pos.y;
			}else if(mn.x == pos.x){
				if(mn.y > pos.y) {
					mn.x = pos.x;
					mn.y = pos.y;
				}
			}
		}
		return mn;
	}

	public final static int dx[] = { -1, 0, 1, 0 };
	public final static int dy[] = { 0, -1, 0, 1 };

	public static int[] searchFish() {
		boolean[][] visited = new boolean[N][N];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(shark.x, shark.y));
		visited[shark.x][shark.y] = true;
		int distance = 0;
		while (!q.isEmpty()) {
			int qSiz = q.size();
			for (int i = 0; i < qSiz; i++) {
				Pos pos = q.poll();
				if(map[pos.x][pos.y] != 0 && map[pos.x][pos.y] < shark.size) {
					Pos rsult = chooseFish(pos, q, qSiz - i - 1);
					return new int[] {rsult.x, rsult.y, distance};
				}
				for (int k = 0; k < 4; k++) {
					int cx = pos.x + dx[k];
					int cy = pos.y + dy[k];
					if (0 <= cx && 0 <= cy && cx < N && cy < N && !visited[cx][cy] 
							&& map[cx][cy] <= shark.size) {
						q.offer(new Pos(cx, cy));
						visited[cx][cy] = true;
					}
				}
			}
			distance++;
		}
		return null;
	}

	public static void moveShark(int x, int y, int distance) {
		moveCnt += distance;
		shark.x = x;
		shark.y = y;
	}

	public static void eatfish(int x, int y, int distance) {
		map[x][y] = 0;
		moveShark(x, y, distance);
		if (++feed == shark.size) {
			feed = 0;
			shark.size++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				if ((map[i][j] = Integer.parseInt(st.nextToken())) > 0) {
					if (map[i][j] == 9) {
						map[i][j] = 0;
						shark = new Fish(i, j, 2);
					}
				}
			}
		}
		int[] food;
		while ((food = searchFish()) != null) {
			eatfish(food[0], food[1], food[2]);
		}
		System.out.println(moveCnt);
	}
}
