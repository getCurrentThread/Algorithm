import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st;
        int n, m;

        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, m));
    }

    private static int solution(int n, int k) {
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                if(--k == 0) {
                    return i;
                }
            }
        }
        return 0;
    }

}