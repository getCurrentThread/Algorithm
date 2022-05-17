import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        long sum = 0, temp, max = 0;
        for (int i = 0; i < n; i++) {
            temp = Long.parseLong(st.nextToken());
            sum += temp;
            max = Math.max(max, temp);
        }

        if (sum == 1 || sum / 2 >= max) {
            out.append("Happy");
        } else {
            out.append("Unhappy");
        }

        System.out.println(out);
    }
}