import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int[][] map;
	static Vector<Vector<int[]>> island;
	static int N;
	static int islandCnt;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void dfs(int x, int y) {
		island.get(islandCnt).add(new int[] {x, y});
		map[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (0 <= cx && 0 <= cy && cx < N && cy < N && map[cx][cy] == 1) {
				dfs(cx, cy);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		island = new Vector<Vector<int[]>>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		islandCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					island.add(new Vector<int[]>());
					dfs(i, j);
					islandCnt++;
				}
			}
		}
		int mn = Integer.MAX_VALUE;
		for(int i = 0; i < island.size(); i++) {
			for(int j = i + 1; j < island.size(); j++) {
				Vector<int[]> a = island.get(i);
				Vector<int[]> b= island.get(j);
				for(int x = 0; x < a.size(); x++) {
					for(int y = 0; y < b.size(); y++) {
						int [] pos1= a.get(x);
						int [] pos2 = b.get(y);
						mn = Math.min(mn, Math.abs(pos1[0]-pos2[0])+ Math.abs(pos1[1]-pos2[1]));
					}
				}
			}
		}
		System.out.println(mn-1);
	}
}
