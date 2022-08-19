import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n;
        int tcase = 1;
        while((n = Integer.parseInt(in.readLine())) != 0) {

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = in.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            int result = solution(n, map);
            out.append("Problem " + tcase + ": " + result + "\n");
            tcase++;
        }

        System.out.print(out);
    }
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;
        Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    // 다익스트라 (0, 0) -> (n - 1, n - 1)
    private static int solution(final int n, final int[][] map) {
        int[][] distance = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        // distance 값 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        visited[0][0] = true;
        distance[0][0] = map[0][0];
        pq.add(new Node(0, 0, map[0][0]));


        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int value = node.value;

            if (x == n - 1 && y == n - 1) {
                return value;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                distance[nx][ny] = Math.min(distance[nx][ny], value + map[nx][ny]);
                pq.add(new Node(nx, ny, value + map[nx][ny]));
            }
        }

        return distance[n - 1][n - 1];
    }

}