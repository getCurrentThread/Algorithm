import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int N, M;
	static List<int[]> h;
	static List<int[]> c;

	static int[][] distVal;
	static List<Integer> sel;

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		h = new ArrayList<>();
		c = new ArrayList<>();

		sel = new ArrayList<>();

		int tmp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				tmp = Integer.parseInt(st.nextToken());
				switch (tmp) {
				case 1:
					h.add(new int[] { i, j });
					break;
				case 2:
					c.add(new int[] { i, j, 0 });
					break;
				}
			}
		}

		distVal = new int[h.size()][c.size()];
		for (int i = 0; i < c.size(); i++) {
			for (int j = 0; j < h.size(); j++) {
				distVal[j][i] += getDistance(c.get(i), h.get(j));
			}
		}

		dfs(0);
		
		System.out.println(ans);
	}

	public static void dfs(int cnt) {
		if (sel.size() == M) {
			int tmp = 0;
			for (int i = 0; i < h.size(); i++) {
				int r = Integer.MAX_VALUE;
				for (int j = 0; j < sel.size(); j++) {
					int c = sel.get(j);
					r = Math.min(r, getDistance(i, c));
				}
				tmp += r;
			}
			ans = Math.min(tmp, ans);
		}
		for (; cnt < c.size(); cnt++) {
			sel.add(cnt);
			dfs(cnt + 1);
			sel.remove(sel.size() - 1);
		}
	}
	
	private static int getDistance(int h, int c) {
		return distVal[h][c];
	}
	private static int getDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
