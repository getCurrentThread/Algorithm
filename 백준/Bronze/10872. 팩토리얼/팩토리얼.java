import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        System.out.println(factorial(N));
    }

    private static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }
}