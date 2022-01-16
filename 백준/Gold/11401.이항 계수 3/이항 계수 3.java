import java.util.Scanner;

public class Main {
    static final long MOD = 1000000007L;
    public static void main(String[] args) {
        long N, K;
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        K = sc.nextLong();
        long top = (factorial(K) * factorial(N-K)) % MOD;
        long ans = (factorial(N) * pow(top, MOD - 2)) % MOD;
        System.out.println(ans);
    }

    private static long factorial(long n) {
        if(n < 0)
            throw new ArithmeticException();
        long k = 1L;
        while(n > 1){
            k = (k * n--) % MOD;
        }
        return k;
    }

    private static long pow(long b, long exp){
        long lft = 1L;
        while(exp > 1) {
            if(exp % 2 == 1) {
                lft = (lft * b) % MOD;
                exp = exp - 1;
            }
            b = (b * b) % MOD;
            exp /= 2;
        }
        return (b * lft) % MOD;
    }
}
