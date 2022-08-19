import java.io.*;
import java.util.*;

public class Main {
    static final int RED = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            if (isBipartite(graph, V)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBipartite(List<List<Integer>> graph, int V) {
        int[] visited = new int[V + 1];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= V; i++) {
            if (visited[i] != 0) continue;
            q.add(i);
            visited[i] = RED;

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph.get(cur)) {
                    if (visited[next] == 0) {
                        q.add(next);
                        visited[next] = visited[cur] == RED ? BLUE : RED;
                    } else if (visited[next] == visited[cur]) { // 이분 그래프가 아님
                        return false;
                    }
                }
            }
        }
        return true;
    }
}