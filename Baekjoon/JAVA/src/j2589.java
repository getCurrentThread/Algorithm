import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class j2589 {
    static int N, M;
    static char[][] map;
    static int ans;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public int compareTo(Node o) {
            return this.step - o.step;
        }
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<Node>();
        boolean[][] visited = new boolean[N][M];
        Node st = new Node(x, y, 0);
        q.offer(st);
        visited[st.x][st.y] = true;

        while (!q.isEmpty()) {
            st = q.poll();
            for (int i = 0; i < 4; i++) {
                int cx = st.x + dx[i];
                int cy = st.y + dy[i];
                if (0 <= cx && 0 <= cy && cx < N && cy < M && map[cx][cy] == 'L' && !visited[cx][cy]) {
                    visited[cx][cy] = true;
                    q.offer(new Node(cx, cy, st.step + 1));
                }
            }
        }

//		q.offer(new Node(st.x, st.y, 0));
//		visited[st.x][st.y] = false;
//
//		while (!q.isEmpty()) {
//			st = q.poll();
//			for (int i = 0; i < 4; i++) {
//				int cx = st.x + dx[i];
//				int cy = st.y + dy[i];
//				if (0 <= cx && 0 <= cy && cx < N && cy < M && map[cx][cy] == 'L' && visited[cx][cy]) {
//					visited[cx][cy] = false;
//					q.offer(new Node(cx, cy, st.step + 1));
//				}
//			}
//		}

        ans = Math.max(ans, st.step);

        //removeIsland(st.x, st.y);
    }

    static void removeIsland(int x, int y) {
        map[x][y] = 'W';
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (0 <= cx && 0 <= cy && cx < N && cy < M && map[cx][cy] == 'L') {
                removeIsland(cx, cy);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = in.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L')
                    bfs(i, j);
            }
        }

        System.out.println(ans);
    }
}