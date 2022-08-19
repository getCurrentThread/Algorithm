import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int Tcase = Integer.parseInt(in.readLine());
        for(int t = 1; t<= Tcase; t++){
            int k = Integer.parseInt(in.readLine());
            int n = Integer.parseInt(in.readLine());
            System.out.println(dp(k, n));
        }
    }
    static int memo[][] = new int[15][15];
    private static int dp(final int k, final int n) {
        if(k == 0)
            return n;
        if(memo[k][n] != 0)
            return memo[k][n];
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += dp(k-1, i);
        }
        return memo[k][n] = sum;
    }
}