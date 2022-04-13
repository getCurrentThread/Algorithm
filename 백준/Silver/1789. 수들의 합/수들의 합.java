import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        long s = Long.parseLong(in.readLine());

        System.out.println(solution(s));
    }

    private static long solution(long s) {
        long n = 1, tmp;
        while (true) {
            tmp = n * (n + 1) / 2;
            if (s == tmp)
                return n;
            else if (s < tmp)
                return n - 1;
            n++;
        }
    }
}