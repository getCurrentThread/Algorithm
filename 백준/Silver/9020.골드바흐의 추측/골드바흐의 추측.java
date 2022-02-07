import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int Tcase = Integer.parseInt(in.readLine());

        for (int t = 1; t <= Tcase; t++) {
            int N = Integer.parseInt(in.readLine());
            int mn = Integer.MAX_VALUE;
            for (int i = N; i >= N/2; i--) {
                if (!isNotPrime[i] && !isNotPrime[N - i]) {
                    mn = i;
                }
            }
            System.out.println(N-mn + " " + mn);
        }
    }

    static final int MAX = 10000 + 1;
    static boolean isNotPrime[] = new boolean[MAX];

    static {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < MAX; i++) {
            for (int j = i * 2; j < MAX; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}