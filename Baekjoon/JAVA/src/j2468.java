import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j2468 {
    static int[][] map;
    static int[][] tMap;
    static int n;
    static int cnt;
    static int mx;
    static int M = 4;

    static final int[] dx = { 0, 0, -1, 1 };
    static final int[] dy = { 1, -1, 0, 0 };

    public static void dfs(int x, int y) {
        tMap[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (0 <= cx && 0 <= cy && cx < n && cy < n && M < tMap[cx][cy] ) {
                dfs(cx, cy);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (M = 0; M < 100; M++) {
            cnt=0;
            tMap = new int[n][];
            for (int i = 0; i < n; i++) {
                tMap[i] = map[i].clone();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (M < tMap[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            mx = Math.max(mx, cnt);
        }
        System.out.println(mx);
    }
}
