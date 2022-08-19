import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int n, m, d;
	static int[][] map;
	static int[] archer = new int[3];
	static int mx;

	static final int[] dx = { 0, -1,0  };
	static final int[] dy = { -1, 0,1  };

	public static int[] shoot(int x, int y, int[][] tMap) { // bfs search.
		Queue<int[]> q = new LinkedList<int[]>();
		boolean visited[][] = new boolean[n][m];
		q.offer(new int[] { x - 1, y });
		int distance = 1;
		while(!q.isEmpty()) {
			int qsiz = q.size();
			for(int i = 0; i < qsiz; i++) {
				int[] pos = q.poll();
				if(tMap[pos[0]][pos[1]] == 1) {
					return new int[] {pos[0], pos[1]};
				}
				for(int j = 0 ; j < 3; j++) {
					int cx = pos[0] + dx[j];
					int cy = pos[1] + dy[j];
					if(0<=cx && 0<=cy && n > cx && m > cy && visited[cx][cy] == false) {
						q.offer(new int[] {cx, cy});
						visited[cx][cy] = true;
					}
				}
			}
			if(++distance > d) break;
		}
		return null;
	}

	public static void simulation() {
		int cnt = 0;
		int[][] tMap = new int[n][];
		for (int i = 0; i < n; i++) {
			tMap[i] = map[i].clone();
		}
		Vector<int[]> v= new Vector<>();
		for (int j = n; j > 0; j--) {
			v.clear();
			for (int i = 0; i < 3; i++) {
				v.add(shoot(j, archer[i], tMap));
			}
			//dummy();
			for (int i = 0; i < v.size(); i++) {
				int[] ele = v.get(i);
				if(ele == null) continue;
				if (tMap[ele[0]][ele[1]] == 1) {
					tMap[ele[0]][ele[1]] = 0;
					cnt++;
				}
			}
			//dummy();
		}
		mx = Math.max(mx, cnt);
	}

	//private static void dummy() {
	//}

	public static void combination(int n, int cnt) { //가능한 궁수 배치 조합
		if (n == 3) { // 궁수 3마리가 찼을 때 시뮬레이팅
			simulation();
			return;
		}
		for (int i = cnt; i < m; i++) {
			archer[n] = i;
			combination(n + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(mx);
	}
}
