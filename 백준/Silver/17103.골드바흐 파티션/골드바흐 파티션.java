import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int T, N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		T = Integer.parseInt(in.readLine().trim());
		seive(1000000);
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine().trim());
			out.append(solve(N)).append('\n');
		}
		System.out.print(out);
	}

	static int prime[];

	private static void seive(final int N) {
		List<Integer> p = new ArrayList<>();
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) {
				p.add(i);
				for (int j = i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		}
		prime = p.stream().mapToInt(Integer::valueOf).toArray();
	}

	private static long solve(final int N) {
		long ans = 0;
		int left = 0, right = Arrays.binarySearch(prime, N);
		right = right >= 0 ? right : Math.abs(right) - 2; // lower_bound
		// 투 포인터
		int sum;
		while (left <= right) {
			sum = prime[left] + prime[right];
			if (sum > N) { // 소수의 합이 N보다 큰 경우 : 작아지는 쪽으로 이동
				--right;
			} else if (sum < N) { // 소수의 합이 N보다 작은 경우 : 커지는 쪽으로 이동
				++left;
			} else { // sum == N 인 경우, 카운트 증가 시키고, left, right를 안쪽으로 이동
				++ans;
				--right;
				++left;
			}
		}
		return ans;
	}
}