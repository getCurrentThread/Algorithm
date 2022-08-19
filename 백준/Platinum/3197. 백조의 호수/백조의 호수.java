import java.io.*;
import java.util.*;

public class Main {
    static final int[] posX = {0, 1, 0, -1};
    static final int[] posY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int R, C;
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][];
        for (int i = 0; i < R; i++)
            map[i] = in.readLine().toCharArray();

        int[][] lake = init(map, R, C);

        // 파라메트릭 서치
        int ans = solve(lake, R, C);
        System.out.println(ans);
    }

    private static int solve(final int[][] lake, final int R, int C) {

        //오리 찾기
        List<Node> ducks = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j] == -1)
                    ducks.add(new Node(i, j, 0));
            }
        }

        int left = 0, right = 1500, mid = (left + right) / 2;
        int ans = mid;
        while (left <= right) {
            if (isCanMeet(lake, R, C, mid, ducks.get(0), ducks.get(1))) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        return ans;
    }

    private static boolean isCanMeet(final int[][] lake, final int R, final int C, final int day, final Node start, final Node end) {

        boolean[][] visited = new boolean[R][C];
        visited[start.x][start.y] = true;
        return dfs(lake, R, C, visited, day, start.x, start.y, end.x, end.y);
    }

    private static boolean dfs(final int[][] lake, final int R, final int C, boolean[][] visited, final int day, final int sx, final int sy, final int ex, final int ey) {

        if(sx == ex && sy == ey)
            return true;

        int x, y;
        for (int i = 0; i < 4; i++) {
            x = sx + posX[i];
            y = sy + posY[i];
            if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y] || lake[x][y] > day)
                continue;
            visited[x][y] = true;
            if (dfs(lake, R, C, visited, day, x, y, ex, ey))
                return true;
        }

        return false;
    }

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

    private static int[][] init(char[][] map, final int R, final int C) {

        int[][] lake = new int[R][C];
        //오리 위치를 연산 편의를 위해 제거
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    map[i][j] = '.';
                    lake[i][j] = -1;
                }
            }
        }

        Queue<Node> q = new ArrayDeque<Node>();

        int x, y;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') { // 빙하인 경우, 주변에 물이 있는지 확인
                    for (int k = 0; k < 4; k++) {
                        x = i + posX[k];
                        y = j + posY[k];
                        if (x < 0 || x >= R || y < 0 || y >= C || map[x][y] == 'X') continue;
                        q.add(new Node(i, j, 1));
                        break;
                    }
                }
            }
        }

        //큐를 사용하여 lake 맵 초기화
        while (!q.isEmpty()) {
            final Node node = q.poll();
            if (lake[node.x][node.y] != 0) continue; //이미 초기화가 된 상태라면

            lake[node.x][node.y] = node.step;

            for (int i = 0; i < 4; i++) {
                x = node.x + posX[i];
                y = node.y + posY[i];
                if (x < 0 || y < 0 || x >= R || y >= C || map[x][y] == '.') continue;
                q.add(new Node(x, y, node.step + 1));
            }
        }

        return lake;
    }
}
