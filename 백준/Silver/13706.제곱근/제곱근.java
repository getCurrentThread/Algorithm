import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(in.readLine().trim());
		System.out.println(sqrt(N));
	}

	private static BigInteger sqrt(final BigInteger n) {
		final BigInteger TWO = BigInteger.valueOf(2);
		BigInteger left, right, mid;

		// 1 <= mid <= n/2
		left = BigInteger.ONE;
		right = n.divide(TWO);
		mid = left.add(right).divide(TWO);

		int cmp;
		while (left.compareTo(right) < 0) {
			cmp = n.divide(mid).compareTo(mid);
			if (cmp > 0) { // 커지는 쪽으로 이동
				left = mid.add(BigInteger.ONE);
			} else if (cmp < 0) { // 작아지는 쪽으로 이동
				right = mid.subtract(BigInteger.ONE);
			} else { // n == mid^2
				return mid; // 빠른 결과 반환을 위해
			}
			mid = left.add(right).divide(TWO); // (left + right) / 2
		}
		return left;
	}
}