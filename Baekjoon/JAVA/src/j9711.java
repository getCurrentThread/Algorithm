import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class j9711 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(in.readLine().trim());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int P = Integer.parseInt(st.nextToken());
            long Q = Long.parseLong(st.nextToken());
            long ans = fibo(P, Q);
//			out.append("Case #").append(t).append(": ").append(ans).append('\n');
            System.out.println("Case #" + t + ": " + ans);
        }
//		System.out.print(out);
    }

    private static long fibo(int p, long q) {
        long [] memo = new long[3];
        Arrays.fill(memo, 1L);

        while (p-- > 2) {
            memo[p % 3] = (memo[(p-1) % 3] + memo[(p-2) % 3]) % q;
        }
        return memo[2] % q;
    }
}