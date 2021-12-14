import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class j12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String S, T;
        S = in.readLine().trim();
        T = in.readLine().trim();

        System.out.println(solve(S, T));
    }

    private static int solve(final String S, final String T) {
        final String revT = new StringBuilder(T).reverse().toString();
        Deque<String> q = new ArrayDeque<>();
        q.add(S);
        while (!q.isEmpty()) {
            String str = q.poll();
            if (str.length() == T.length()) {
                if (T.equals(str))
                    return 1;
                continue;
            }
            if (T.contains(str) || revT.contains(str)) {
                q.offer(str + "A");
                q.offer(new StringBuilder(str).reverse().append('B').toString());
            }
        }
        return 0;
    }
}
