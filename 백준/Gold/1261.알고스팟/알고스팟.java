import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;

	/** (0,0)좌표에서 해당 (x,y) 좌표까지 최소한으로 부술 수 있는 벽의 갯수. BFS시에 visited 역할도 수행 */
	static int[][] memo;
	static int ans;

	public static class Pos {
		int x;
		int y;
		int broken;

		public Pos(int x, int y, int broken) {
			this.x = x;
			this.y = y;
			this.broken = broken;
		}
	}

	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };
	
	/**BFS 방식으로 순회, 이때에 memo에 있는 값이 순회할 (x,y) 좌표의 부순 블록의 최솟값을 저장하게 되며,
	 *  이 값보다 노드의 블록을 부순 값이 작은 경우만 갱신 가능
	 */
	public static void bfs() {
		memo = new int[M][N];
		for (int i = 0; i < M; i++)
			Arrays.fill(memo[i], Integer.MAX_VALUE); // 최소 갯수를 갱신하기 위해, 정수 int형 최댓값으로 초기화

		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(0, 0, 0));
		memo[0][0] = 0; // (1,1)은 항상 뚫려있으므로 0으로 초기화

		while (!q.isEmpty()) {
			Pos tmp = q.poll();
			for (int i = 0; i < 4; i++) { // 사방 탐색
				int cx = tmp.x + dx[i];
				int cy = tmp.y + dy[i];
				if (0 <= cx && 0 <= cy && cx < M && cy < N && memo[cx][cy] > (tmp.broken + map[cx][cy])) { // 기존 다른 노드에
																											// 비해 블럭을 부순
																											// 횟수가 적은
																											// 노드라면
					memo[cx][cy] = tmp.broken + map[cx][cy]; // 부순 블럭의 갯수 갱신
					q.offer(new Pos(cx, cy, memo[cx][cy]));
				}
			}
		}

		ans = memo[M - 1][N - 1]; // (1, 1) -> (N, M) 까지의 최소로 벽돌을 부수는 갯수
	}

	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String row = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}

		// BFS
		bfs();

		// 출력
		System.out.println(ans);
	}
}
