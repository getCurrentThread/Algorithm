import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class j3345 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N;
        String s;
        N = Integer.parseInt(in.readLine().trim());
        s = in.readLine().trim();
        System.out.println(solve(N, s));
    }

    private static long solve(final int N, final String str) {
        long[] memo = new long[N + 2];
        long tmp;

        int depth = 1;
        char[] cArr = str.toCharArray();

//		if (cArr[0] == ')')
//			return 0l; // 존재할 수 없는 경우를 배제
        memo[1] = 1; // m[0, 1] = 1;

        for (int i = 1; i < N; i++) {
            switch (cArr[i]) {
                case '(':
                    ++depth;
                    for (int k = depth; k >= 0; k -= 2) {
                        tmp = k > 0 ? memo[k - 1] : 0;
                        tmp = (tmp + memo[k + 1]) % 1000000009L;
                        memo[k] = tmp;
                    }
                    break;
                case ')':
//				if (--depth < 0)
//					return 0;
                    --depth;
                    for (int k = depth; k >= 0; k -= 2) {
                        memo[k] = memo[k + 1];
                    }
                    memo[depth + 1] = 0L;
                    break;
            }
        }
        return memo[0];
    }
}