import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int Tcase;
	static Pos a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		Tcase = Integer.parseInt(in.readLine().trim());
		a = new Pos();
		b = new Pos();
		for (int t = 1; t <= Tcase; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			a.x = Integer.parseInt(st.nextToken());
			a.y = Integer.parseInt(st.nextToken());
			b.x = Integer.parseInt(st.nextToken());
			b.y = Integer.parseInt(st.nextToken());
			int ans = solution();
			out.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(out);
	}

	private static int solution() {
		int ans = 0;
		int[] diff = new int[2];
		diff[0] = Math.abs(a.x - b.x);
		diff[1] = Math.abs(a.y - b.y);
		if (diff[0] < diff[1]) {
			int tmp = diff[0];
			diff[0] = diff[1];
			diff[1] = tmp;
		}

		while (!(diff[0] == 0 && diff[1] == 0)) {
			if(diff[0] > 0) {
				diff[0]--;
			}
			else {
				diff[0]++;
			}
			ans++;
			if (diff[0] == 0 && diff[1] == 0)
				break;
			if(diff[1] > 0) {
				diff[1]--;
			}else {
				diff[1]++;
			}
			ans++;
		}
		return ans;
	}

	static class Pos {
		int x;
		int y;
	}
}
