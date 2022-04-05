import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        System.out.println(fibo(n));
    }

    static long memo[] = new long[91];

    private static long fibo(int n) {
        if(memo[n] != 0) return memo[n];
        if(n < 2) return n;
        return memo[n] = fibo(n-1) + fibo(n-2);
    }
}