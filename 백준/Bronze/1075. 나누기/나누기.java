import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int f = Integer.parseInt(in.readLine());

        n = n / 100 * 100;

        for(int i = 0; i < 100; i++) {
            if((n + i) % f == 0) {
                n = n + i;
                break;
            }
        }
        System.out.println(String.format("%02d", n % 100));
    }
}
