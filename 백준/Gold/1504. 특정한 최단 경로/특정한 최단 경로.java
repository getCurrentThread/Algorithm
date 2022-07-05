import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
            graph[v][u] = w;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // Math.min(1~v1 + v2~N, 1~v2 + v1~N) + v1~v2
        int center = dijkstra(graph, v1, v2);
        int result = Math.min(
                dijkstra(graph, 1, v1) + dijkstra(graph, v2, N)
                , dijkstra(graph, 1, v2) + dijkstra(graph, v1, N)
        ) + center;

        // warning: Adding 3-value can cause an overflow.
        System.out.println((center == INF || result >= INF) ? -1 : result);
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }

    private static int dijkstra(int[][] graph, int start, int end) {
        int N = graph.length;
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int v = cur.v;
            int w = cur.w;
            if (dist[v] < w) continue;
            for (int i = 1; i < N; i++) {
                if (graph[v][i] != INF) {
                    if (dist[i] > dist[v] + graph[v][i]) {
                        dist[i] = dist[v] + graph[v][i];
                        pq.add(new Pair(i, dist[i]));
                    }
                }
            }
        }
        return dist[end];
    }
}