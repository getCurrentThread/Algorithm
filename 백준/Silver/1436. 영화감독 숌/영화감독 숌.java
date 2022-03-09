import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int tmp = 666;
        while (n > 0) {
            if (check(tmp++)) {
                n--;
            }
        }
        System.out.println(tmp - 1);
    }

    private static boolean check(int i) {
        int cnt;
        while (i > 0) {
            cnt = 0;
            while (i > 0 && i % 10 == 6) {
                if (++cnt >= 3) return true;
                i /= 10;
            }
            i /= 10;
        }

        return false;
    }
}