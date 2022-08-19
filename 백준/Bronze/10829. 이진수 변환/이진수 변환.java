import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        long n = Long.parseLong(in.readLine());
        while(n > 0) {
            out.append(n % 2);
            n /= 2;
        }
        System.out.println(out.reverse());
    }
}
