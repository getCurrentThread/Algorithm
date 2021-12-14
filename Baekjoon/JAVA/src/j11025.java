import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j11025 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N, K;
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(solve(N, K));
    }

    private static int solve(final int N, final int K) {
        int D[] = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            D[n] = (D[n - 1] + K) % n;
        }
        return D[N] + 1;
    }
}