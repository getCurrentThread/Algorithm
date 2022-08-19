import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long c1 = Long.parseLong(st.nextToken());
        /* long c2 = */ Long.parseLong(st.nextToken());
        long c3 = Long.parseLong(st.nextToken());
        /* long c4 = */ Long.parseLong(st.nextToken());
        long c5 = Long.parseLong(st.nextToken());
        long c6 = Long.parseLong(st.nextToken());

        long x1, x3, x5, x7;

        long x2 = gcd(c1, c5);
        long x6 = gcd(c3, c6);

        x1 = c1 / x2;
        x3 = c5 / x2;
        x5 = c6 / x6;
        x7 = c3 / x6;

        bw.write(x1 + " ");
        bw.write(x2 + " ");
        bw.write(x3 + " ");
        bw.write(x5 + " ");
        bw.write(x6 + " ");
        bw.write(x7 + "\n");

        bw.flush();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}