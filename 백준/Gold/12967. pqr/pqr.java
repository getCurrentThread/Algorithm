import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N, K;
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long[] A = new long[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		System.out.println(solve(N, K, A));
	}

	private static long solve(final int N, final long K, long[] A) {
		Map<Long, Long> m = new HashMap<>();

		long val;
		for (int i = 0; i < N; i++) {
			val = gcd(A[i], K);
			m.put(val, m.getOrDefault(val, 0l) + 1);
		}
		long count = 0;

		Entry<Long, Long>[] arr = m.entrySet().toArray(new Map.Entry[m.size()]);

		long Ikey, JKey, KKey;
		long Ivalue, Jvalue, Kvalue;

		// 같은 값 3개로 만들 수 있는 조합이 있을 때
		for (int i = 0; i < arr.length; i++) {
			Ikey = arr[i].getKey();
			Ivalue = arr[i].getValue();
			if (Ivalue >= 3 && Ikey * Ikey * Ikey % K == 0)
				count += Ivalue * (Ivalue - 1) * (Ivalue - 2) / 6;
		}

		// 같은 값 2개로 만들 수 있는 조합이 있을 때
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				Ikey = arr[i].getKey();
				JKey = arr[j].getKey();
				Ivalue = arr[i].getValue();
				Jvalue = arr[j].getValue();
				if (Ivalue >= 2 && Ikey * Ikey * JKey % K == 0)
					count += Ivalue * (Ivalue - 1) * Jvalue / 2;
				if (Jvalue >= 2 && JKey * JKey * Ikey % K == 0)
					count += Jvalue * (Jvalue - 1) * Ivalue / 2;
			}
		}

		// 모두 다른 값으로 만들 수 있는 조합이 있을 때
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if(arr[i].getKey() * arr[j].getKey() * arr[k].getKey() % K == 0)
						count += arr[i].getValue() * arr[j].getValue() * arr[k].getValue();
				}
			}
		}
		return count;
	}

	private static long gcd(long a, long b) {
		if (a < b)
			return gcd(b, a);
		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}
