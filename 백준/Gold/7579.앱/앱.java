import java.io.*;
import java.util.*;

/*
input:
5 60
30 10 20 35 40
3 0 3 5 4

output:
6
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int ans = solution(N, M, memory, cost);
        System.out.println(ans);
    }
    
    static final int COST_MAX = 10000;
    private static int solution(final int N, final int M, int[] memory, int[] cost) {
        // dp[비용] = 최대 메모리용량; (memory 기준으로 하면 TLE)
        int[] dp = new int[COST_MAX+1];

        for (int i = 0; i < N; i++) {
            for (int j = COST_MAX; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-cost[i]] + memory[i]);
            }
        }

        for(int i = 0; i <= COST_MAX; i++){
            if(dp[i] >= M) return i;
        }

        throw new RuntimeException("정답이 없네요...?");
    }
}