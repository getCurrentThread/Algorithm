import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine()); // N kg.
        int[] dp = new int[N+1]; // dp[i] = min. cost to buy i kg.

        // 1 cost per 3kg, 5kg
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        //greedy
        for(int i = 0 ; i*5 <=N; i++){
            dp[i*5] = i;
        }

        // 5번 갱신
        for(int k = 0; k < 5; k++) {
            //3kg
            for (int i = N; i >= 3; i--) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
        }

        if(dp[N] == MAX) {
            System.out.println(-1);
        }else{
            System.out.println(dp[N]);
        }
    }
}
