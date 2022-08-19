import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        System.out.println(dp(n));
    }

    static long memo[];
    static {
        memo = new long[1000001];
        memo[1] = 1;
        memo[2] = 2;
    }
    private static long dp(final int n) {
        if(n < 0) return 0;
        if(memo[n] != 0) return memo[n];
        return memo[n] = (dp(n - 1) + dp(n - 2)) % 15746;
    }
}