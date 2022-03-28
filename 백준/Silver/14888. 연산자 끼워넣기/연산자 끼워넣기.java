import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int[] operands = new int[n];
        int[] operators = new int[4];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = simulate(n, operands, operators);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int mx  = -1000000001, mn = 1000000001;
    private static int[] simulate(int n, int[] operands, int[] operators) {
        dfs(operands, operators, operands[0], n, 1);
        return new int[] {mx, mn};
    }

    private static void dfs(int[] operands, int[] operators, int val, int n, int depth) {
        if(depth == n) {
            mx = Math.max(mx, val);
            mn = Math.min(mn, val);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                switch(i) {
                    case 0:
                        dfs(operands, operators, val + operands[depth], n, depth + 1);
                        break;
                    case 1:
                        dfs(operands, operators, val - operands[depth], n, depth + 1);
                        break;
                    case 2:
                        dfs(operands, operators, val * operands[depth], n, depth + 1);
                        break;
                    case 3:
                        dfs(operands, operators, val / operands[depth], n, depth + 1);
                }
                operators[i]++;
            }
        }
    }


}