import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int Tcase;
	static int N, M;
	static int mx;
	static List<List<Integer>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		Tcase = Integer.parseInt(in.readLine().trim());
		for(int t = 1; t <= Tcase; t++) {
			graph = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph.add(null);
			for(int i = 1; i <= N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			int a, b;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			int ans = simulation();
			out.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(out);
	}
	private static int simulation() {
		mx = 1;
		boolean visited[] = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			dfs(1, i, visited);
		}
		return mx;
	}
	private static void dfs(int depth, int start, boolean visited[]) {
		visited[start] = true;
		mx = Math.max(mx, depth);
		
		int nxt;
		List<Integer> node = graph.get(start);
		for(int i = 0; i < node.size(); i++) {
			nxt = node.get(i);
			if(!visited[nxt]) {
				dfs(depth+1, nxt, visited);
			}
		}
		visited[start] = false;
	}
}
