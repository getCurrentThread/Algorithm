import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int test_case = 0;
        int L, P, V;
        while (true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) break;

            System.out.println("Case " + ++test_case + ": " + solution(L, P, V));
        }

    }

    private static int solution(int l, int p, int v) {
        return (v / p) * l + Math.min(l, (v % p));
    }
}
