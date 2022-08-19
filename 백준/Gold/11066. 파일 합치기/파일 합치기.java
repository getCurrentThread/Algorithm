import java.io.*;
import java.util.*;
/*
input:
2
4
40 30 30 50
15
1 21 3 4 5 35 5 4 3 5 98 21 14 17 32

output:
300
864
*/
public class Main {
    final static int MAX = 500000001;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(in.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int ans = solution(n, arr);
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }

    static int memo[][];
    static int sum[];

    private static int solution(final int N, final int[] costs) {
        memo = new int[N][N];
        sum = new int[N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(memo[i], MAX);
        }

        for(int i = 0; i < N; i++) {
            memo[i][i] = 0;
        }

        sum[0] = costs[0];
        for(int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + costs[i];
        }
        //step
        // 1. (i, j) : (0, 1), (1, 2), (2, 3), (3, 4), ..., (N - 1, N)
        // 2. (i, j) : (0, 2), (1, 3), (2, 4), (3, 5), ..., (N - 2, N)
        for (int step = 1; step < N; step++) {
            for (int i = 0; i + step < N; i++) {
                int j = i + step;
                int cost = sum[j] - (i > 0 ? sum[i-1]: 0);
                for(int k = i; k < j; k++) {
                    memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k + 1][j] + cost);
                }
            }
        }

        return memo[0][N - 1];
    }
}
