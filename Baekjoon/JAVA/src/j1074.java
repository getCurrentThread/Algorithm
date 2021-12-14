import java.util.Scanner;

public class j1074 {
    static long N, r, c;
    static long ans;

    public static void solve(long x, long y, long len, long cnt) {
        long xdiff = c - x, ydiff = r - y;
        long half = len / 2;
        if (0 <= xdiff && 0 <= ydiff && xdiff < len && ydiff < len) {
            if (len == 1 && xdiff == 0 && ydiff == 0) {
                ans = cnt;
            }
            solve(x, y, half, cnt);
            solve(x + half, y, half, cnt + pow(half, 2));
            solve(x, y + half, half, cnt + pow(half, 2) * 2);
            solve(x + half, y + half, half, cnt + pow(half, 2) * 3);
        }
    }

    public static long pow(long a, long n) {
        int tmp = 1;
        while (n-- > 0) {
            tmp *= a;
        }
        return tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        r = sc.nextLong();
        c = sc.nextLong();
        solve(0, 0, pow(2, N), 0);

        System.out.println(ans);
    }
}
