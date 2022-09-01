import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }

    private static int[] makePalindrome(int[] num) {
        int[] ret = num.clone();
        int lo = 0, hi = ret.length - 1;
        while (lo < hi) {
            ret[hi--] = ret[lo++];
        }
        return ret;
    }

    private static String solve(final String n) {
        int[] origin = n.chars().map(c -> c - '0').toArray();
        int[] next = origin.clone();

        int[] palindrome = makePalindrome(next);
        while (compare(origin, palindrome) >= 0) {
            next = up(next);
            palindrome = makePalindrome(next);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : palindrome) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static int[] up(int[] next) {
        int center = next.length / 2;
        if (++next[center] >= 10) {
            // carry
            for (int i = center; i >= 1; i--) {
                if (next[i] < 10) break;
                next[i - 1]++;
                next[i] = 0;
            }
        }
        if (next[0] >= 10) { // last carry...
            next[0] = 0;
            int[] temp = new int[next.length + 1];
            System.arraycopy(next, 0, temp, 1, next.length);
            temp[0] = 1;
            next = temp;
        }
        return next;
    }

    private static int compare(int[] a, int[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return Integer.compare(a[i], b[i]);
            }
            return 0;
        }
        return Integer.compare(a.length, b.length);
    }
}