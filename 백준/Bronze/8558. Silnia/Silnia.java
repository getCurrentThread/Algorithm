import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        if (n < 5) {
            int tmp = 1;
            for (int i = 2; i <= n; i++) {
                tmp *= i;
            }
            result = tmp % 10;
        }

        System.out.println(result);
    }
}