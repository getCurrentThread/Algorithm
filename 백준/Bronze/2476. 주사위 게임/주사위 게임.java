

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int result = 0;
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b && b == c) {
                result = Math.max(result, 10000 + a * 1000);
            } else if (a == b || b == c || a == c) {
                result = Math.max(result, 1000 + (a + b + c - (a ^ b ^ c)) * 100 / 2);
            } else {
                result = Math.max(result, Math.max(Math.max(a, b), c) * 100);
            }
        }
        System.out.println(result);
    }
}
