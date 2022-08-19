import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.append(dp(a, b)).append("\n");
        }
        System.out.print(out);
    }

    static long memo[][] = new long[31][31];

    static { //기저조건
        for (int i = 1; i < 31; i++) {
            memo[1][i] = i; // n == 1, m = k인 경우 다리 건설은 k 만큼 가능
            memo[i][i] = 1; // n == m인 경우 다리 건설은 한개만 가능
        }
    }

    private static long dp(final int a, final int b) {
        if (memo[a][b] != 0) return memo[a][b];
        return memo[a][b] = dp(a, b - 1) + dp(a - 1, b - 1); // m쪽 점이 하나가 더 늘어난다면, 기존에 지을 수 있는 갯수인 dp[n][m-1]에,
                                                                      // 새로 늘어난 한개를 반드시 쓸 수 있는 경우인 dp[n-1][m-1]을 더해준다. (*점화식)
    }
}
