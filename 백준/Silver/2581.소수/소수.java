import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M  = Integer.parseInt(in.readLine());
        int N  = Integer.parseInt(in.readLine());

        seive(N);

        int sum = 0;
        int mn = Integer.MAX_VALUE;
        for(int i = M; i <= N; i++) {
            if(!isNotPrime[i]) {
                sum += i;
                mn = Math.min(mn, i);
            }
        }

        if(sum == 0) {
            System.out.println("-1");
        }else{
            System.out.println(sum);
            System.out.println(mn);
        }
    }
    static boolean isNotPrime[];
    private static void seive(int m) {
        isNotPrime = new boolean[m+1];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i <= m; i++) {
            for(int j = 2; i*j <= m; j++) {
                isNotPrime[i*j] = true;
            }
        }
    }
}