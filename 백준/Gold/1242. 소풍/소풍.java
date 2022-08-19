import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N, K, M;
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		System.out.println(solve(N, K, M));
	}

	/**
	 * 
	 * @param N 참여한 총 인원 수
	 * @param K 순환하는 스텝 수
	 * @param M 동호의 위치
	 * @return
	 */
	private static long solve(long N, long K, long M) {
		// K = (K == N) ? K : K % N; // 한바퀴 이상 순환할 수 있으므로, 스텝수를 최적화
		while (true) {
			if (M % K == 0) // 동호의 위치M가 스텝 수에 의해 정확히 나누어 떨어지면 해당 결과를 반환
				return M / K;
			M += (N - M / K); // 탈락 당하지 않은 수 만큼 동호의 위치M에 더하여 위치M를 뒤로 재설정
		}
	}
}