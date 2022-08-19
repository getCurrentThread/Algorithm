import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    final static int MAX_WEIGHT = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // dijkstra
        System.out.println(solve(graph, start, end));
    }

    private static int solve(List<List<Node>> graph, int start, int end) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, -1);

        Queue<Node> mheap = new PriorityQueue<>(Comparator.comparingInt(o -> -o.w));
        mheap.add(new Node(start, MAX_WEIGHT));
        dist[start] = MAX_WEIGHT;

        while (!mheap.isEmpty()) {
            Node cur = mheap.poll(); // 현재 정점까지의 허용 중량
            if (cur.v == end) {
                return cur.w;
            }
            for (Node next : graph.get(cur.v)) {
                int weight = Math.min(cur.w, next.w); // 이 점점에서 다리를 건넘으로서의 허용 중량
                if (/*dist[next.v] == -1 || */dist[next.v] < weight) {
                    mheap.add(new Node(next.v, weight));
                    dist[next.v] = weight;
                }
            }
        }
        return -1; // 도착할 수 없음
    }
}