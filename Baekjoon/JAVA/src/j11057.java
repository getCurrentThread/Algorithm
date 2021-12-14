import java.util.Scanner;

public class j11057 {
    static int N;
    static int[][] memo;

    // Top-down
    /**
     *
     * @param place k자리
     * @param digit 0~9의 숫자
     * @return
     */
    public static int dp(int place, int digit) {
        if(digit < 0) return 0;
        if (memo[place][digit] != 0)
            return memo[place][digit];
        return memo[place][digit] = (dp(place,digit-1) + dp(place-1,digit)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        memo = new int[N][10];
        for (int i = 0; i < 10; i++) {
            memo[0][i] = i + 1;
        }
        System.out.println(dp(N-1, 9));
    }
}
