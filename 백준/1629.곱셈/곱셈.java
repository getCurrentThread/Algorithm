import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine());

			int x = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int MOD = Integer.parseInt(st.nextToken());

			System.out.println(pow(x, N, MOD));

			return;
		}

		static long pow(long x, long n, final long MODULO) {

			// 기저조건
			if (n == 0)
				return 1;

			if (n % 2 == 0)
				return pow(x * x % MODULO, n / 2, MODULO) % MODULO;
			return x * pow(x * x % MODULO, n / 2, MODULO) % MODULO;
		}
	}

