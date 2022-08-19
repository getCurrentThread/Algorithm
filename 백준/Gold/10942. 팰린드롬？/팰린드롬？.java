import java.io.*;
import java.util.*;

/*
input:
7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7

output:
1
0
1
1
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(in.readLine());
        int[][] queries = new int[M][2];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }

        int ans[] = solution(N, arr, queries);
        for(int i = 0; i < ans.length; i++) {
            out.append(ans[i]).append('\n');
        }
        System.out.print(out);
    }

    // 조건
    // dp[s][e] = dp[s-1][e+1] && (arr[s] == arr[e])
    private static int[] solution(final int N, int[] arr, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        boolean dp[][] = new boolean[N][N];

        // 길이가 1인 경우
        for(int i = 0; i < N; i++){
            dp[i][i] = true;
        }

        // 길이가 2인 경우
        for(int i = N-2; i >= 0; i--){
            dp[i][i+1] = arr[i] == arr[i+1];
        }

        // 길이 3 이상부터
        for(int step = 2; step < N; step++){
            for(int s = 0; s + step < N; s++){
                int e = s + step;
                dp[s][e] = dp[s+1][e-1] && arr[s] == arr[e];
            }
        }

        for(int i =0; i < queries.length; i++){
            int s = queries[i][0] - 1;
            int e = queries[i][1] - 1;
            ans.add(dp[s][e]? 1 : 0);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}