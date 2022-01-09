import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] items;
	static int[][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		items = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			items[i][0] = Integer.parseInt(st.nextToken()); // 무게 w
			items[i][1] = Integer.parseInt(st.nextToken()); // 가치 v
		}

		memo = new int[N][K + 1];
		// 연산
		for (int j = items[0][0]; j <= K; j++) {
			memo[0][j] = items[0][1];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				if (items[i][0] > j) { // 제한 무게보다 무거운 경우
					memo[i][j] = memo[i - 1][j];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - items[i][0]] + items[i][1]);
				}
			}
		}

		// 출력
		System.out.println(memo[N-1][K]);
	}
}
