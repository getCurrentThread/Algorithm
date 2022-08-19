import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        List<List<Integer>> graph = new ArrayList<>(n);
        graph.add(null);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[next] = cur; // 부모 표시
                }
            }
        }

        for(int i =2; i<=n; i++){
            out.append(parent[i]).append('\n');
        }

        System.out.print(out);
    }
}