import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000;
    static int[] memo;
    static int cycle;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(in.readLine());
        init();
        System.out.println(fibo((int)(N % cycle)));
    }

    private static void init(){
        memo = new int[2000000];
        memo[0] = 0;
        memo[1] = 1;

        int n = 2;
        while(true){
            if(fibo(n) == 0 && fibo(n+1) == 1){
                cycle = n;
                break;
            }
            n++;
        }
    }

    private static int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memo[n] != 0) return memo[n];
        return memo[n] = (fibo(n-1) + fibo(n-2)) % MOD;
    }
}
