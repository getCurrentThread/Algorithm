import java.io.BufferedReader;
import java.io.InputStreamReader;

public class j2239 {
    static int[][] map = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][][] sqr = new boolean[3][3][10];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        for (int i = 0; i < 9; i++) {
            String r = in.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = r.charAt(j) - '0';
            }
        }
        // 시뮬레이션
        simulation();

        // 출력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void simulation() {
        // 가로, 세로 체크
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                row[i][map[i][j]] = true;
                col[j][map[i][j]] = true;
            }
        }
        // 3x3 체크
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sqr[i / 3][j / 3][map[i][j]] = true;
            }
        }

        // dfs 탐색 시작
        dfs(0, 0, 0);
    }

    private static boolean dfs(int x, int y, int cnt) {
        if (cnt == 81)
            return true;

        int cy = y + 1;
        int cx = (cy == 9 )? x + 1 : x;
        cy %= 9;

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) { // 1부터 9까지 테스트
                if (row[x][i] || col[y][i] || sqr[x / 3][y / 3][i]) //가로, 세로, 3x3에 i에 해당하는 값이 있다면 패스
                    continue;
                map[x][y] = i; // i 대입 시도
                row[x][i] = true;
                col[y][i] = true;
                sqr[x / 3][y / 3][i] = true;
                if(dfs(cx, cy, cnt+1)) {
                    return true;
                }
                row[x][i] = false;
                col[y][i] = false;
                sqr[x / 3][y / 3][i] = false;
            }
            map[x][y] = 0;
        } else { // 0 이 아닌 값이 있다면
            return dfs(cx, cy, cnt + 1);
        }
        return false;
    }
}
