import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int map[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                String line = in.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            System.out.println(solution(map, r, c));
        }
    }

    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};

    private static int solution(int[][] map, int r, int c) {
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 0) continue;

                // 블록이 있는 곳에는 반드시 상하 블록면, 2개가 존재한다.
                cnt += 2;

                // 하나의 블록 사면을 순회하며 사면이 막혀져 있지 않은 곳을 카운트 한다.
                for (int b = map[i][j]; b > 0; b--) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= r || y < 0 || y >= c || map[x][y] < b) cnt++;
                    }
                }
            }
        }


        return cnt;
    }
}