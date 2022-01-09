import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int K;

	static int L;
	static Queue<Node> q;

	static class Node {
		int sec;
		int dir;
	}

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		N = Integer.parseInt(in.readLine().trim());
		map = new int[N][N];
		K = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = 2;
		}
		L = Integer.parseInt(in.readLine().trim());
		q = new LinkedList<>();

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			Node node = new Node();
			node.sec = Integer.parseInt(st.nextToken());
			node.dir = st.nextToken().charAt(0) == 'D' ? 1 : -1;
			q.add(node);
		}

		int time = 0;
		int length = 1;
		int x = 0;
		int y = 0;
		int dir = 0;

		while (!q.isEmpty() && q.peek().sec == time) { // 0초 때에 방향 전환
			while (q.peek().sec == time) {
				dir = (4 + dir + q.poll().dir) % 4;
			}
		}

		Queue<Pos> body = new LinkedList<>();
		while (true) {
			time++;

			// 기존 머리 위치에 몸통이 올 것이므로
			map[x][y] = 1;
			body.add(new Pos(x, y));
			
			// 머리 이동
			x += dx[dir];
			y += dy[dir];
			if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 1) {
				break; // 몸통에 부딪히거나, 바깥으로 머리가 나가는 경우
			}
			if (map[x][y] == 2) { // 사과를 먹음
				length++;
			}
			map[x][y] = 9;
			
			while (!q.isEmpty() && q.peek().sec == time) {
				dir = (4 + dir + q.poll().dir) % 4;
			}
			
			while (body.size() >= length) { // 몸통 이동
				Pos pos = body.poll();
				map[pos.x][pos.y] = 0;
			}
		}

		System.out.println(time);
	}
}
