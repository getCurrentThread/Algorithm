import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Fish {
	int x;
	int y;
	int size;

	public Fish(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

}

class Feed extends Fish {
	int distance;

	public Feed(int x, int y, int size, int distance) {
		super(x, y, size);
		this.distance = distance;
	}
}

public class Main {
	static int N;
	static Fish shark;
	static int map[][];

	static int feedCnt;
	static int moveCnt;

	public static void eat(Feed feed) {
		shark.x = feed.x;
		shark.y = feed.y;
		moveCnt += feed.distance;
		if (++feedCnt >= shark.size) {
			shark.size++;
			feedCnt = 0;
		}
	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	private static boolean attackFeed() {

		PriorityQueue<Feed> pq = new PriorityQueue<>((a, b) -> {
			if (a.distance == b.distance)
				if (a.x == b.x)
					return a.y - b.y;
				else
					return a.x - b.x;
			else
				return a.distance - b.distance;
		});
		boolean visited[][] = new boolean[N][N];

		Feed feed = new Feed(shark.x, shark.y, 0, 0);
		pq.add(feed);
		visited[shark.x][shark.y] = true;

		while (!pq.isEmpty()) {
			feed = pq.poll();
			if (feed.size != 0 && feed.size < shark.size) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int cx = feed.x + dx[i];
				int cy = feed.y + dy[i];
				if (0 <= cx && 0 <= cy && cx < N && cy < N && !visited[cx][cy]) {
					visited[cx][cy] = true;
					if(map[cx][cy] > shark.size)
						continue;
					if(map[cx][cy] == shark.size)
						pq.add(new Feed(cx, cy, 0, feed.distance + 1));
					else
						pq.add(new Feed(cx, cy, map[cx][cy], feed.distance + 1));
				}
			}
		}
		if (feed.size != 0 && feed.size < shark.size) {
			eat(feed);
			map[feed.x][feed.y] = 0;
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 상어위치 비우기
					map[i][j] = 0;
					shark = new Fish(i, j, 2);
				}
			}
		}

		while (attackFeed() == true)
			;

		System.out.println(moveCnt);
	}

}
