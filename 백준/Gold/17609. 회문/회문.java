import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            sb.append(check(br.readLine())).append('\n');
        }
        System.out.print(sb);
    }

    private static int[] checkPalindrome(char[] ch, int lo, int hi) {
        while (lo < hi) {
            if (ch[lo] != ch[hi]) return new int[]{lo, hi};
            ++lo;
            --hi;
        }
        return new int[]{lo, hi};
    }

    private static boolean isPalindrome(int[] lohi) {
        return lohi[0] >= lohi[1];
    }

    private static int check(String word) {
        char[] ch = word.toCharArray();
        int lo = 0, hi = ch.length - 1;
        int[] lohi = checkPalindrome(ch, lo, hi);
        if (isPalindrome(lohi)) return 0; // is palindrome.
        else if (isPalindrome(checkPalindrome(ch, lohi[0] + 1, lohi[1]))
                || isPalindrome((checkPalindrome(ch, lohi[0], lohi[1] - 1))))
            return 1;
        return 2;
    }
}