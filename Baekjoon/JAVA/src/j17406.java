import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class j17406 {
    static int N, M, K;
    static int[][] map, tMap;
    static List<Rotate> rotates;

    static List<Integer> sel;
    static boolean[] visited;

    static int ans = Integer.MAX_VALUE;

    static class Rotate {
        int y;
        int x;
        int len;

        public Rotate(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }

    public static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotates = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            rotates.add(new Rotate(y, x, len));
        }
        sel = new ArrayList<>();
        visited = new boolean[K];
    }

    public static void permutation() {
        if (sel.size() == K) {
            simulate();
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel.add(i);
                permutation();
                sel.remove(sel.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void simulate() {
        // 원본 배열 copy.
        tMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tMap[i], 0, M);
        }

        // rotate
        for (int i = 0; i < K; i++) {
            Rotate r = rotates.get(sel.get(i));
            recurRotate(r.y - 1, r.x - 1, r.len);
        }

        // ans update
        int tmp;
        for (int i = 0; i < N; i++) {
            tmp = 0;
            for (int j = 0; j < M; j++) {
                tmp += tMap[i][j];
            }
            ans = Math.min(ans, tmp);
        }
    }

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    private static void recurRotate(int y, int x, int len) {
        if (len == 0)
            return;
        recurRotate(y, x, len - 1);

        int r = y, c = x;
        x -= len;
        y -= len;
        int tmp = tMap[y][x];

        int i = 0;
        while (i != 4) {
            tMap[y][x] = tMap[y + dy[i]][x + dx[i]];
            x += dx[i];
            y += dy[i];
            if (Math.abs(x - c) + Math.abs(y - r) == len * 2)
                i++;
        }
        tMap[y][x + 1] = tmp;
    }

    public static void main(String[] args) throws Exception {
        input();

        permutation();

        System.out.println(ans);
    }
}
