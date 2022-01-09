import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int[] values = new int[N+1];
			for (int i = 1; i <= N; i++) {
				values[i] = Integer.parseInt(st.nextToken());
			}
			List<List<Integer>> graphs = new ArrayList<>(N + 1);
			for (int i = 0; i <= N; i++) {
				graphs.add(new ArrayList<>());
			}

			int s, e;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				graphs.get(e).add(s);
			}

			int W = Integer.parseInt(in.readLine().trim());

			int[] dist = new int[N + 1];
			Arrays.fill(dist, -1);
			int answer = solve(graphs, values, dist, W);
			out.append(answer).append('\n');
		}
		System.out.print(out);
	}

	private static int solve(final List<List<Integer>> graphs, final int[] values, int[] dist, final int w) {
		// 기존에 계산된 적이 있다면
		if (dist[w] != -1)
			return dist[w];
		// 기초 건물이라면
		if (graphs.get(w).size() == 0)
			return dist[w] = values[w];
		for (int before : graphs.get(w)) {
			dist[w] = Math.max(dist[w], values[w] + solve(graphs, values, dist, before));
		}
		return dist[w];
	}
}
