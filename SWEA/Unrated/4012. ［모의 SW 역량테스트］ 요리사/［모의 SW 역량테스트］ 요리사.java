import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;

	static int map[][];

	static int ans;

	public static int getSynergy(int i, int j) {
		if (i <= j)
			return map[i][j];
		else
			return map[j][i];
	}

	static boolean visited[];

	private static void dfs(int i, int depth) {
		if (depth == N / 2) { // 기저조건 체크
			int half = N / 2;
			int a[] = new int[half], b[] = new int[half];
			int ac = 0, bc = 0, sum = 0;
			for (i = 0; i < N; i++) {
				if (visited[i]) {
					a[ac++] = i;
				} else {
					b[bc++] = i;
				}
			}
			for (int k = 0; k < half; k++) {
				for (int j = k + 1; j < half; j++) {
					sum += getSynergy(a[k], a[j]);
					sum -= getSynergy(b[k], b[j]);
				}
			}
			ans = Math.min(ans, Math.abs(sum));
			return;
		}
		for (; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			StringTokenizer st;

			ans = Integer.MAX_VALUE;
			map = new int[N][N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					if (i <= j)
						map[i][j] += Integer.parseInt(st.nextToken());
					else
						map[j][i] += Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);

			out.append('#').append(t).append(' ').append(ans).append('\n');
		}
		System.out.print(out);
	}

}
