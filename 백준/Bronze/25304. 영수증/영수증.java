import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long total = 0;
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final long a = Long.parseLong(st.nextToken());
            final long b = Long.parseLong(st.nextToken());
            total += a * b;
        }

        if (x == total) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
