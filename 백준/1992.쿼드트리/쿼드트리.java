import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[][] map;
	static StringBuilder ans;

	public static boolean isSame(int x, int y, int len) {
		boolean tmp = map[x][y];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (tmp != map[x + i][y + j])
					return false;
			}
		}
		return true;
	}

	public static void solve(int x, int y, int len) {
		if (len == 1) {
			ans.append(map[x][y] == true ? '1' : '0');
			return;
		}
		// check equals
		if (isSame(x, y, len))
			ans.append(map[x][y] == true ? '1' : '0');
		else {
			int half = len / 2;
			ans.append('(');
			solve(x, y, half);
			solve(x, y + half, half);
			solve(x + half, y, half);
			solve(x + half, y + half, half);
			ans.append(')');
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ans = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String row = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = row.charAt(j) == '1' ? true : false;
			}
		}

		solve(0, 0, N);

		System.out.println(ans.toString());
	}
}
