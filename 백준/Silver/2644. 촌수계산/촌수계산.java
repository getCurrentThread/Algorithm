import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int result = solve(graph, x, y);
        System.out.println(result);
    }

    private static int solve(List<List<Integer>> graph, int x, int y) {
        //bfs
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(x);
        visited[x] = true;

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == y) return depth;
                for (int nxt : graph.get(cur)) {
                    if (visited[nxt]) continue;
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
            depth++;
        }

        // not found...
        return -1;
    }


}
