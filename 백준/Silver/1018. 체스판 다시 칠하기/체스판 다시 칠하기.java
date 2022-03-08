import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = in.readLine().toCharArray();
        }

        int result = simulate(map, n, m);
        System.out.println(result);
    }

    static char[][] chessBoard = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    private static int simulate(char[][] map, final int n, final int m) {
        int mn = 64;
        for (int i = 0; i + 8 <= n; i++) {
            for (int j = 0; j + 8 <= m; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (map[i + k][j + l] == chessBoard[k][l]) {
                            cnt++;
                        }
                    }
                }
                cnt = Math.min(cnt, 64 - cnt);
                mn = Math.min(mn, cnt);
            }
        }
        return mn;
    }
}
