import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(n, m, 1, out);
        System.out.print(out);
    }

    static int memo[] = new int[8];
    private static void dfs(final int n, final int m, final int depth, final StringBuilder out) {
        if(depth == m){
            for(int i = 1; i <= n; i++) {
                for (int j = 1; j < m; j++) {
                    out.append(memo[j]).append(' ');
                }
                out.append(i).append('\n');
            }
            return;
        }

        for(int i = 1; i <= n; i++){
            memo[depth] = i;
            dfs(n, m, depth + 1, out);
        }
    }

}