import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class j1194 {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
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

        int ans = simulate();
        System.out.println(ans);
    }

    static final int dx[] = { 0, 0, -1, 1 };
    static final int dy[] = { -1, 1, 0, 0 };

    private static int simulate() {

        boolean isGoal = false;

        Queue<Node> q = new LinkedList<Node>();
        visited = new boolean[N][M][64];

        // '0' 위치부터 큐 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    q.add(new Node(i, j, 0));
                    visited[i][j][0] = true;
                    break;
                }
            }
        }
        int step = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            step++;
            // 탐색 1 depth 실행
            while (qSize-- > 0) {
                Node node = q.poll();
                if (map[node.x][node.y] == '1') {
                    isGoal = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int cx = node.x + dx[i];
                    int cy = node.y + dy[i];
                    if (cx < 0 || cy < 0 || cx >= N || cy >= M || map[cx][cy] == '#' || visited[cx][cy][node.keys]) {
                        continue;
                    }
                    visited[cx][cy][node.keys] = true; // 방문체크
                    if ('a' <= map[cx][cy] && map[cx][cy] <= 'f') { //열쇠가 있는 자리인 경우
                        int keys = node.keys | (1 << (int)(map[cx][cy] - 'a'));
                        visited[cx][cy][keys] =  true; // 방문체크
                        q.add(new Node(cx, cy, keys));
                    }else if('A' <= map[cx][cy] && map[cx][cy] <= 'F') { //문이 있는 자리인 경우
                        if((node.keys & (1 << (int)(map[cx][cy] - 'A'))) > 0) { //문에 맞는 키가 있다면
                            q.add(new Node(cx, cy, node.keys));
                        }
                    }else {
                        q.add(new Node(cx,cy,node.keys));
                    }
                }
            }
            if(isGoal) { //골에 도착한 경우 반복문 종료
                break;
            }

        }
        if (isGoal) {
            return step;
        } else
            return -1;
    }

    static class Node {
        int x;
        int y;
        int keys;

        public Node(int x, int y, int keys) {
            this.x = x;
            this.y = y;
            this.keys = keys;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", keys=" + keys + "]";
        }

    }
}
