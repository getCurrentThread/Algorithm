import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class j16973 {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        int N, M, H, W;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Pos> walls = new ArrayList<Pos>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine().trim());
            for (int j = 0; j < M; j++) {
                if (1 == Integer.parseInt(st.nextToken())) {
                    walls.add(new Pos(i, j));
                }
            }
        }
        st = new StringTokenizer(in.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Pos start = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        Pos end = new Pos(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        System.out.println(solve(N, M, H, W, walls, start, end));
    }

    final static int dx[] = { -1, 1, 0, 0 };
    final static int dy[] = { 0, 0, -1, 1 };

    private static int solve(final int N, final int M, final int H, final int W, final List<Pos> walls, final Pos start,
                             final Pos end) {
        boolean[][] check = new boolean[N][M];

        int cx, cy;
        // 벽에 의해 갈 수 없는 영역을 지움
        for (Pos wall : walls) {
            for (int i = 0; i < H; i++) {
                cx = wall.x - i;
                if (cx < 0 || cx >= N)
                    continue;
                for (int j = 0; j < W; j++) {
                    cy = wall.y - j;
                    if (cy < 0 || cy >= M)
                        continue;
                    check[cx][cy] = true;
                }
            }
        }

        // 격자 바깥으로 나갈 수 없도록 영역을 지움 (길이가 1이라면 격자 바깥으로 나갈 일이 없으므로 제외)
        if (H > 1) {
            cx = N - H + 1;
            for (int i = 0; i < M; i++) {
                check[cx][i] = true;
            }
        }
        if (W > 1) {
            cy = M - W + 1;
            for (int i = 0; i < N; i++) {
                check[i][cy] = true;
            }
        }

        Deque<Pos> q = new ArrayDeque<Pos>();
        check[start.x][start.y] = true;
        q.offer(start);

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pos pos = q.poll();
                if (pos.x == end.x && pos.y == end.y)
                    return count;
                for (int i = 0; i < 4; i++) {
                    cx = pos.x + dx[i];
                    cy = pos.y + dy[i];
                    if (cx < 0 || cx >= N || cy < 0 || cy >= M || check[cx][cy])
                        continue;
                    check[cx][cy] = true;
                    q.offer(new Pos(cx, cy));
                }
            }
            count++;
        }
        return -1;
    }
}