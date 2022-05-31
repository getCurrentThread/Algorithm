import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int Tcase;
	static int N, M;
	static boolean[][] students, rStudents;
//	static List<Integer> graph[];
//	static List<Integer> rGraph[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		Tcase = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= Tcase; t++) {
			N = Integer.parseInt(in.readLine().trim());
			M = Integer.parseInt(in.readLine().trim());
//			graph = new ArrayList[N + 1];
//			rGraph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
//				graph[i] = new ArrayList<Integer>();
//				rGraph[i] = new ArrayList<Integer>();
			}

			students = new boolean[N + 1][N + 1];
			rStudents = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
//				graph[a].add(b);
//				rGraph[b].add(a);
				students[a][b] = true;
				rStudents[b][a] = true;
			}

//			numbers = new int[N + 1];

			int ans = simulate();

			out.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(out);
	}

//	static int numbers[];
//
//	private static void dfs(int n, int depth, boolean[] visited, List<Integer> graph[]) {
//		visited[n] = true;
//		numbers[depth] = n;
//		for (int i = 0; i <= depth; i++) {
//			students[n][numbers[i]] = true;
//		}
//		for (int i = 0; i < graph[n].size(); i++) {
//			dfs(graph[n].get(i), depth + 1, visited, graph);
//		}
//	}

	private static int simulate() {
		int ans = 0;
//		boolean visited[];
//		// 정방향으로 DFS로 가능한 모든 노드 방문
//		visited = new boolean[N + 1];
//		for (int i = 1; i <= N; i++) {
//			dfs(i, 0, visited, graph);
//		}
//
//		// 역방향으로 DFS로 가능한 모든 노드 방문
//		visited = new boolean[N + 1];
//		for (int i = 1; i <= N; i++) {
//			dfs(i, 0, visited, rGraph);
//		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (students[i][k] && students[k][j])
						students[i][j] = true;
					if (rStudents[i][k] && rStudents[k][j])
						rStudents[i][j] = true;
				}
			}
		}
		// 카운팅
		for (int s = 1; s <= N; s++) {
			int j = 1;
			for (; j <= N; j++) {
				if (students[s][j] || rStudents[s][j] || s == j)
					continue;
				break;
			}
			if (j == N + 1) {
				ans++;
			}
		}
		return ans;
	}
}
