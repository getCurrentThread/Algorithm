import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int N = Integer.parseInt(in.readLine());
            if(N == 0) break;
            int count = 0;
            for(int i = N + 1; i <= 2*N; i++){
                if(!isNotPrime[i])
                    count++;
            }
            System.out.println(count);
        }
    }

    static final int MAX = 123456 * 2 + 1;
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