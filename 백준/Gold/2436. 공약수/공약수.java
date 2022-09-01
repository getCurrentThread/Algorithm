import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] ret = solve(a, b);
        System.out.println(ret[0] + " " + ret[1]);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int[] solve(int a, int b) {
        int divide = b / a; // 두 수의 약수가 서로소인 약수에 대한 곱 180 / 6 = 30...
        for (int i = (int) Math.sqrt(divide); i > 0; i--) {
            if (divide % i == 0 && gcd(i, divide / i) == 1) { // 두 수가 서로소 일 때까지 반복
                return new int[]{i * a, (divide / i) * a};
            }
        }
        return new int[0]; // error!
    }
}