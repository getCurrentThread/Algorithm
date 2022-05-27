import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int Tcase;
	static int arr[], op[];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		arr = new int[9];
		op = new int[9];
		Tcase = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= Tcase; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			simulation();
			out.append(String.format("#%d %d %d\n", t, ans, 362880 - ans));
		}
		System.out.print(out);
	}

	private static void simulation() {
		ans = 0;
		boolean[] visited = new boolean[19];
		for (int i = 0; i < 9; i++) {
			visited[arr[i]] = true;
		}
		int index = 0;
		for (int i = 1; i <= 18; i++) {
			if (!visited[i])
				op[index++] = i;
		}
		Arrays.fill(visited, false); // 재활용
		dfs(0, 0, visited);
	}

	private static void dfs(int depth, int sum, boolean[] visited) {
		if (depth == 9) { //기저 조건
			if(sum > 0)
				ans++;
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth+1, sum + (arr[i] > op[depth] ? arr[i] + op[depth] : -(arr[i] + op[depth]) ), visited );
				visited[i] = false;
			}
		}
	}
}
