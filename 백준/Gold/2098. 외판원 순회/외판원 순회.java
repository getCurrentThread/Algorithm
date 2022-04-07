import java.io.*;
import java.util.*;
/*
input:
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

output:
35
 */
public class Main {
    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(line[j]);
            }
        }

        // i -> j로 갈 수 없는 경우는 0으로 주어지므로 가중치를 MAX로 수정
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(dist[i][j] == 0)
                    dist[i][j] = MAX;
            }
        }

        int ans = solution(N, dist);
        System.out.println(ans);
    }

    private static int solution(final int N, final int[][] dist) {
        // dp[mask][cur] : 방문한 도시 집합(mask)에서 현재 cur를 방문한 경우의 최소 거리
        int[][] dp = new int[1 << N][N];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }
        return TSP(N, dist, dp, 1 << 0, 0);
    }

    private static int TSP(final int N, final int[][] dist, final int[][] dp, final int mask, final int cur) {
        if (mask == (1 << N) - 1) { // 모든 도시를 방문한 경우 다시 0으로 방문
            return dist[cur][0];
        }

        if (dp[mask][cur] != MAX) { // 메모이제이션
            return dp[mask][cur];
        }

        int mn = MAX;
        for (int next = 0; next < N; next++) {
            if ((mask & (1 << next)) == 0) {
                mn = Math.min(mn, dist[cur][next] + TSP(N, dist, dp, mask | (1 << next), next));
            }
        }
        
        return  dp[mask][cur] = mn;
    }
}
