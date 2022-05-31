import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static Pos island[];
	static double E;
	static int V;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Pos() {
		}
	}

	static class Vex implements Comparable<Vex> {
		int u, v;
		double w;

		public Vex(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Vex o) {
			if (this.w > o.w)
				return 1;
			else if (this.w < o.w)
				return -1;
			else
				return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			island = new Pos[N];
			for (int i = 0; i < N; i++) {
				island[i] = new Pos();
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				island[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				island[i].y = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(in.readLine());

			long ans = prim();
			out.append('#').append(t).append(' ').append(ans).append('\n');
		}
		System.out.println(out);
	}

	static double getCost(Pos a, Pos b) {
		return (Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2)) * E;
	}

	// 최소신장트리 프림 알고리즘
	private static long prim() {
		double sum = 0;
		boolean[] visited = new boolean[N];
		PriorityQueue<Vex> pq = new PriorityQueue<>();

		visited[0] = true;
		for (int i = 1; i < N; i++)
			pq.add(new Vex(0, i, getCost(island[0], island[i])));

		int count = 0;
		while (!pq.isEmpty()) {
			Vex vex = pq.poll();
			if (!visited[vex.v]) {
				visited[vex.v] = true;
				for (int i = 1; i < N; i++) {
					if (!visited[i])
						pq.add(new Vex(vex.v, i, getCost(island[vex.v], island[i])));
				}
				sum += vex.w;
				count++;
				if (count == N - 1) {
					break;
				}
			}
		}
		return Math.round(sum);
	}
}
