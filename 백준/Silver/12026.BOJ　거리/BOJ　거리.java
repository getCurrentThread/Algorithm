import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		String s = in.readLine().trim();
		System.out.println(solve(N, s));
	}

	static final String rotate = "BOJ";

	private static int solve(final int N, final String str) {
		if (N == 1)
			return 0; // N=1인 경우, 스타트와 링크가 이미 만나있기 때문에...

		int memo[] = new int[N];
		Arrays.fill(memo, Integer.MAX_VALUE); // MAX_VALUE로 모두 초기화
		memo[0] = 0;

		char[] cArr = str.toCharArray();
		char before;
		int tmp;
		for (int i = 1; i < N; ++i) { // memo[i] = ?
			before = rotate.charAt((rotate.indexOf(cArr[i]) + 2) % 3); // 이전에 있어야할 값 B <- O <- J
			for (int j = i - 1; j >= 0; --j) {
				if (before == cArr[j] && memo[j] != Integer.MAX_VALUE) { // 원하는 문자가 맞으며, 값도 초기화 상태가 아닌 경우
//					if (memo[i] < (tmp = memo[j] + pow2(i - j)))
//						break;
//					memo[i] = tmp;
					memo[i] = Math.min(memo[i], memo[j] + pow2(i - j));
				}
			}
		}
		return memo[N - 1] == Integer.MAX_VALUE ? -1 : memo[N - 1];
	}

	private static int pow2(int num) {
		return num * num;
	}
}