import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        System.out.println(solve(A, B, N));
    }

    private static int solve(int a, int b, int n) {
        while (n-- > 0) {
            a = a % b;
            a = a * 10;
        }
        return a / b;
    }
}