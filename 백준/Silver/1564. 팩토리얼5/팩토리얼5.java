import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 1;
        for (long i = 2; i <= n; i++) {
            result = (result * i);
            while (result % 10 == 0) {
                result /= 10;
            }
            result %= 1e12;
//            System.out.println(String.format("n %d : %05d", i, result % 100000));
        }

        System.out.println(String.format("%05d", result % 100000));
    }
}