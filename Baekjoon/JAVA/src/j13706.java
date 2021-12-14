import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class j13706 {
    static int T;
    static BigInteger N;
    final static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = new BigInteger(in.readLine().trim());
        BigInteger ans = solution();
        System.out.print(ans);
    }

    private static BigInteger solution() {
        if (BigInteger.ONE.compareTo(N) >= 0) {
            return N;
        }
        BigInteger left = BigInteger.ONE;
        BigInteger right = new BigInteger(N.toString());
        BigInteger mid = left.add(right).divide(TWO);
        while (left.compareTo(right) <= 0) {
            BigInteger el = N.divide(mid);
            int ret = el.compareTo(mid);
            if (ret > 0) {
                left = mid.add(BigInteger.ONE);
            } else if (ret < 0) {
                right = mid.subtract(BigInteger.ONE);
            } else {
                return mid;
            }
            mid = left.add(right).divide(TWO);
        }
        return right;
    }
}