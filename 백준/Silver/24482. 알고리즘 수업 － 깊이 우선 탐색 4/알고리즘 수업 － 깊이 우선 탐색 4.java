import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] result = solve(graph, n, r);

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static int[] solve(List<List<Integer>> graph, int n, int r) {
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i), Comparator.reverseOrder());
        }
        int visited[] = new int[n + 1];
        Arrays.fill(visited, -1);
        dfs(graph, visited, r, 0);
        return visited;
    }

    private static void dfs(List<List<Integer>> graph, int[] visited, int cur, int depth) {
        visited[cur] = depth;
        for (int nxt : graph.get(cur)) {
            if (visited[nxt] == -1) {
                dfs(graph, visited, nxt, depth + 1);
            }
        }
    }
}