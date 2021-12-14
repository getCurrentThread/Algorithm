import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class j17472 {
    static int N, M;
    static int[][] map;

    static int iCnt = 2;
    static List<List<Pos>> islands;

    static int rsult;

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { -1, 1, 0, 0 };

    public static void makeIsland(int x, int y, int color) {
        map[x][y] = color;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (0 <= cx && 0 <= cy && cx < N && cy < M) {
                if (map[cx][cy] == 1)
                    makeIsland(cx, cy, color);
                else if (map[cx][cy] == 0)
                    cnt++;
            }
        }

        if (cnt != 0)
            islands.get(color).add(new Pos(x, y));
    }

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        in.close();

        islands = new ArrayList<>();
        islands.add(null);
        islands.add(null);
        // 연산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    islands.add(new ArrayList<>());
                    makeIsland(i, j, iCnt++);
                }
            }
        }

        if (prim())
            System.out.println(rsult);
        else
            System.out.println(-1);
    }

    static class Vex {
        int u, v, w;

        public Vex(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private static boolean prim() {
        boolean visited[] = new boolean[iCnt];
        PriorityQueue<Vex> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });

        // 2부터 붙여진 섬부터 pq에 넣음
        visited[2] = true;
        for (Pos pos : islands.get(2)) {
            for (int i = 0; i < 4; i++) {
                Vex tmp = makeBridge(pos.x, pos.y, i);
                if (tmp != null) {
                    pq.add(tmp);
                }
            }
        }

        int v = 0;
        while (!pq.isEmpty()) {
            Vex vex = pq.poll();
            if (!visited[vex.v]) {
                visited[vex.v] = true;
                rsult += vex.w;
                if (v == iCnt - 3)
                    break;
                for (Pos pos : islands.get(vex.v)) {
                    for (int i = 0; i < 4; i++) {
                        Vex tmp = makeBridge(pos.x, pos.y, i);
                        if (tmp != null && !visited[tmp.v]) {
                            pq.add(tmp);
                        }
                    }
                }
            }
        }

        for (int i = 2; i < iCnt; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    private static Vex makeBridge(int x, int y, int dir) {
        int u = map[x][y];
        int v = 0;

        x += dx[dir];
        y += dy[dir];

        int w = 0;
        while (0 <= x && 0 <= y && x < N && y < M) {
            if (map[x][y] != 0) {
                v = map[x][y];
                break;
            }
            x += dx[dir];
            y += dy[dir];
            w++;
        }
        if (v == 0 || u == v || w < 2)
            return null;
        return new Vex(u, v, w);
    }
}
