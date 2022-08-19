import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(c(n, k));
    }

    static int[] memo = new int[20];
    private static int fact(int n) {
        if (n == 0) return 1;
        if (memo[n] != 0) return memo[n];
        return memo[n] = n * fact(n - 1);
    }

    private static int c(int n, int k) {
        return (int)(fact(n) / ((long) fact(k) * fact(n - k)));
    }
}