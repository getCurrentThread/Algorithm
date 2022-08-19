import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(n, arr) + " " + solution2(n, arr));
    }


    private static int solution1(int n, int[][] arr) {
        int dp[][] = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = arr[i][1] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    private static int solution2(int n, int[][] arr) {
        int dp[][] = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = arr[i][1] + Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
