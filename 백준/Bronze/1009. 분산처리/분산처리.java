import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = pow(a, b);
            out.append(result != 0 ? result : 10).append("\n");
        }
        System.out.print(out);
    }

    static final int DIGIT = 10;

    private static int pow(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a % DIGIT;
        if (b % 2 == 0) {
            return pow(a * a % DIGIT, b / 2) % DIGIT;
        } else {
            return pow(a * a % DIGIT, b / 2) * a % DIGIT;
        }
    }
}
