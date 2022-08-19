import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] == false) {
                for (int j = i; j <= n; j += i) {
                    if (!arr[j]) {
                        arr[j] = true;
                        if (--k == 0)
                            return j;
                    }
                }
            }
        }
        return -1;
    }
}
