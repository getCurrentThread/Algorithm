import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class j1753 {
    static int V, E;
    static int start;
    static boolean visited[];
    static int dist[];
    static List<List<int[]>> graph;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(in.readLine());

        graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[] { v, w });
        }

        daijstra();

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF? "INF": dist[i]);
        }
    }

    private static void daijstra() {
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        pq.add(new int[] { start, 0 });

        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] ele = pq.poll();
            int v = ele[0];
            int min = ele[1];
            if (!visited[v]) {
                visited[v] = true;

                for (int i = graph.get(v).size() - 1; i >= 0; i--) {
                    int[] node = graph.get(v).get(i);
                    int u = node[0];
                    int weight = node[1];
                    if (!visited[u] && dist[u] > min + weight) {
                        dist[u] = min + weight;
                        pq.add(new int[] { u, dist[u] });
                    }
                }

                if (++cnt >= V)
                    return; // 모든 정점 순회 완료
            }
        }

    }
}
