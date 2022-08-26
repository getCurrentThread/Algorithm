import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int u, v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(a, b, c));
        }

        Arrays.stream(solve(n, graph)).forEach(System.out::println);
    }

    private static long[] solve(int n, List<List<Edge>> graph) {
        // 벨만포드 o(v*e)
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        for (int k = 1; k <= n; k++) { // o(n)
            for (int i = 1; i <= n; i++) { // o(e)
                for (Edge edge : graph.get(i)) {
                    if (dist[edge.u] == Long.MAX_VALUE || dist[edge.v] <= dist[edge.u] + edge.w) continue;
                    dist[edge.v] = dist[edge.u] + edge.w;
                }
            }
        }

        // 한번 더 했을 때에 갱신되는 값이 있다면 음수 사이클이 있는 것으로 판단
        for (int i = 1; i <= n; i++) { // o(e)
            for (Edge edge : graph.get(i)) {
                if (dist[edge.u] == Long.MAX_VALUE || dist[edge.v] <= dist[edge.u] + edge.w) continue;
                // dist[edge.v] = dist[edge.u] + edge.w;
                return new long[]{-1};
            }
        }

        return Arrays.stream(Arrays.copyOfRange(dist, 2, n + 1))
                .map(x -> x == Long.MAX_VALUE ? -1 : x)
                .toArray();
    }
}