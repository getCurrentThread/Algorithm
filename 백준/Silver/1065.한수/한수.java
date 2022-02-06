import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        System.out.println(solution(N));
    }

    private static int solution(final int n) {
        if (n > 1000 || n < 0) {
            throw new RuntimeException("N은 1보다 크거나 같고, 1000보다 작거나 같아야 합니다.");
        }
        int count = 0;
        // 100 이하의 숫자의 경우에는 등차수열을 항상 이루므로
        count = (n < 100) ? n : 99;

        // n이 세자리인 경우
        for (int i = 100; i < 1000 && i <= n; i++) {
            int first = i % 10;
            int second = (i / 10) % 10;
            int third = (i / 100) % 10;
            if (first - second == second - third) count++;
        }

        return count;
    }
}