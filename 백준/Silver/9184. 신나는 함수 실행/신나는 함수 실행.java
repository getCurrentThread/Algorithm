import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a != -1 || b != -1 || c != -1) {

            out.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));

            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        System.out.print(out);
    }

    static int memo[][][] = new int[21][21][21];
    static {
        memo[0][0][0] = 1;
        memo[1][1][1] = 2;
        memo[20][20][20] = 1048576;
    }
    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if(memo[a][b][c] != 0) return memo[a][b][c];
        if (a < b && b < c)
            return memo[a][b][c] = w(a, b, c - 1)
                + w(a, b - 1, c - 1)
                - w(a, b - 1, c);
        return memo[a][b][c] = w(a - 1, b, c)
                + w(a - 1, b - 1, c)
                + w(a - 1, b, c - 1)
                - w(a - 1, b - 1, c - 1);
    }
}
