import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = seive(1000000);
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 2; i <= n / 2; i++) {
                if (prime[i] && prime[n - i]) {
                    System.out.println(String.format("%d = %d + %d", n, i, n - i));
                    break;
                }
            }

        }
    }

    private static boolean[] seive(int mx) {
        boolean[] isPrime = new boolean[mx + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= mx; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= mx; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}