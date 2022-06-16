import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr, n);
        System.out.println(w);
        System.out.println(b);
    }

    static int b, w;

    private static void solution(int[][] arr, int n) {
        b = w = 0;
        partition(arr, 0, n, 0, n);
    }

    private static void partition(int[][] arr, int x1, int x2, int y1, int y2) {
        if (check(arr, x1, x2, y1, y2)) {
            if (arr[x1][y1] == 1) {
                b++;
            } else {
                w++;
            }
            return;
        }

        int x = (x1 + x2) / 2;
        int y = (y1 + y2) / 2;

        partition(arr, x1, x, y1, y);
        partition(arr, x, x2, y1, y);
        partition(arr, x1, x, y, y2);
        partition(arr, x, x2, y, y2);
    }

    private static boolean check(int[][] arr, int x1, int x2, int y1, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (arr[x1][y1] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}