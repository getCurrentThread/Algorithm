import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String A = in.readLine().trim();
		String B = in.readLine().trim();

		int len = gcd(A.length(), B.length());

		StringBuilder sba = new StringBuilder();
		for (int i = len / A.length(); i > 0; i--) {
			sba.append(A);
		}
		StringBuilder sbb = new StringBuilder();
		for (int i = len / B.length(); i > 0; i--) {
			sbb.append(B);
		}
		System.out.println(sba.toString().compareTo(sbb.toString()) == 0 ? 1 : 0);
	}

	private static int lcm(int a, int b) {
		if (a < b)
			return lcm(b, a);
		if (a % b == 0)
			return b;
		return lcm(b, a % b);
	}

	private static int gcd(int a, int b) {
		return a / lcm(a, b) * b;
	}
}