import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        char[] lotto = in.readLine().toCharArray();

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(lotto[i] - lotto[i - 1]) == 1) {
                count++;
            } else {
                count = 0;
            }

            if (count >= 4) break;
        }

        if (count >= 4) {
            out.append("YES");
        } else {
            out.append("NO");
        }


        System.out.println(out);
    }
}