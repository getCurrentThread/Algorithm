import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MIN_INF = -100001;
    static int N;
    static int A; // 가능한 요양 신청 횟수
    static int B; // 자습 필수 횟수
    static int[][] p; // 만족도

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        N = Integer.parseInt(in.readLine().trim());

        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 만족도
        p = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
            p[i][2] = Integer.parseInt(st.nextToken());
            p[i][3] = Integer.parseInt(st.nextToken());
        }

        int ans = simulation();
        System.out.println(ans);
    }

    static int[][][][] memo;

    private static int simulation() {
        memo = new int[100][4][101][101];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j <= 100; j++)
                for(int k = 0; k <= 100; k++)
                    memo[0][i][j][k] = MIN_INF;

        // 첫날 값에 대한 만족도 저장
        memo[0][0][1][0] = p[0][0];
        memo[0][1][1][0] = p[0][1];
        memo[0][2][0][0] = p[0][2];
        memo[0][3][0][1] = p[0][3];
        if ((A + B) > N)
            A = N - B;

        int ans = 0;
        for (int b = 100; b >= B; b--) {
            for (int a = A; a >= 0; a--) {
                ans = max(ans, dp(N - 1, 0, b, a), dp(N - 1, 1, b, a), dp(N - 1, 2, b, a), dp(N - 1, 3, b, a));
            }
        }
        return ans;
    }

    private static int dp(int n, int t, int c, int r) {

        if (n < 0 || c < 0 || r < 0)
            return MIN_INF;

        if (n == 0) { //첫날인 경우 (기존 저장해둔 값으로 반환)
            return memo[n][t][c][r];
        }
        if (memo[n][t][c][r] != 0) // 기존에 연산해둔 값이 있는 경우
            return memo[n][t][c][r];

        switch (t) {
            // 공부
            case 0:
            case 1:
                memo[n][t][c][r] = max(
                        dp(n - 1, 0, c - 1, r),
                        dp(n - 1, 1, c - 1, r),
                        dp(n - 1, 2, c - 1, r),
                        dp(n - 1, 3, c - 1, r)) + p[n][t];
                break;
            // 휴게실
            case 2:
                memo[n][t][c][r] = max(
                        dp(n - 1, 0, c, r),
                        dp(n - 1, 1, c, r),
//                        dp(n-1, 2, c-1, r),
                        dp(n - 1, 3, c, r)) + p[n][t];
                break;
            // 요양
            case 3:
                memo[n][t][c][r] = max(
                        dp(n - 1, 0, c, r - 1),
                        dp(n - 1, 1, c, r - 1),
                        dp(n - 1, 2, c, r - 1),
                        dp(n - 1, 3, c, r - 1)) + p[n][t];
                break;
        }

        return memo[n][t][c][r];
    }

    private static int max(final int i1, final int... i2) {
        int ans = i1;
        for (int i : i2) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

}
