import java.io.*;
import java.util.*;
/*
input:
3
5 3
3 2
2 6

output:
90
*/
public class Main {
    static class Node{
        int left;
        int right;

        Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            String[] line = in.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        int ans = solution(n, nodes);
        System.out.println(ans);
    }
    private static int solution(final int N, Node[] nodes) {
        int[][] dp = new int[N][N];

        for(int step = 1; step < N; step++){
            for(int i = 0; i + step < N; i++){
                int j = i + step;
                if(i == j) {
                    dp[i][j] = 0; //자기 자신으로 가는 값은 0으로 설정
                    continue;
                }
                int tmp = Integer.MAX_VALUE; // 최소값을 저장할 임시 변수
                for(int k = i; k < j; k++){
                    tmp = Math.min(tmp, calcMat(nodes[i].left, nodes[k].right, nodes[j].right) + dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = tmp;
            }
        }
        return dp[0][N-1];
    }

    private static int calcMat(final int left, final int mid, final int right){
        return left * mid * right;
    }
}
