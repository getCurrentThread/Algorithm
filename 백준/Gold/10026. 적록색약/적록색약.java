import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = in.readLine().toCharArray();
        }

        int s1 = space(map, n);
        int s2 = spaceBind(map, n);

        System.out.println(s1 + " " + s2);
    }


    private static int space(final char[][] _map, final int n) {
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = _map[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '0') {
                    floodFill(map, n, map[i][j], i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static int spaceBind(final char[][] _map, final int n) {
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = _map[i][j] == 'G' ? 'R' : _map[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '0') {
                    floodFill(map, n, map[i][j], i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    private static void floodFill(char[][] map, final int n, final char color, final int x, final int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != color) continue;
            map[nx][ny] = '0';
            floodFill(map, n, color, nx, ny);
        }
    }
}