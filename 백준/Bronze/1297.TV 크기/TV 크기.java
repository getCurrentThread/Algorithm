import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double alpha = Math.sqrt(square(D) / (double) (square(H) + square(W)));
        System.out.println((int) (H * alpha) + " " + (int) (W * alpha));
    }

    private static long square(long n) {
        return n * n;
    }
}
