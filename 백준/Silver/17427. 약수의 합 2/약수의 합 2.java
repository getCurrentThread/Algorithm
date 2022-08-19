import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        System.out.println(g(n));
    }

    private static long g(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += (n / i) * i;
        }
        return result;
    }

}