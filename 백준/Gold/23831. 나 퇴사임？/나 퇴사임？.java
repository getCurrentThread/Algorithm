import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 자습일 수
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

        // dp 문제네...
        int ans = simulation();
        System.out.println(ans);
    }

    static boolean[][][][] chck;
    static int[][][][] memo;

    private static int simulation() {
        memo = new int[100][4][101][101];
        chck = new boolean[100][4][101][101];

        for(int i = 0; i < 4; i++)
            for(int j = 0; j <= 100; j++)
                for(int k = 0; k <= 100; k++)
                    memo[0][i][j][k] = Integer.MIN_VALUE;

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

//    static int N; // 자습일 수
//    static int A; // 가능한 요양 신청 횟수
//    static int B; // 자습 필수 횟수
    // N 만큼 일정이 있다 친다면 필수 자습 횟수 B만큼 채우고,
    // 나머지 요양 가능 최대 신청 횟수 A만큼 채우고...
    // 즉, (A+B) 의 값이 N보다 넘어가는 시점에서 A값을 깎아야함
    // if ((A+B) > N) A = N - B;

    // 만족도 p[몇일n][자습장소t]
    // int dp[몇일n][자습장소t][정독실소학습실_사용일카운트c][요양일카운트r]
    // int dp[100][4][101][101]
    // c만큼 공부, r만큼 요양한 n일날 t장소에 있을 때 만족도
    private static int dp(int n, int t, int c, int r) {

        // 기저조건
        if (n < 0 || c < 0 || r < 0) //존재할 수 없는 만족도
            return Integer.MIN_VALUE;

        if (n == 0) { //첫날인 경우 (기존 저장해둔 값으로 반환)
            return memo[n][t][c][r];
        }
        if (chck[n][t][c][r]) // 기존에 연산해둔 값이 있는 경우
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

        chck[n][t][c][r] = true;
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
