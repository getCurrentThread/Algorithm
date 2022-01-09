import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c;
	static int[] arr;
	static int[] visited;

	// 투 포인터 풀이
	public static int solution() {
		int ans = 0;
		int end = N * 2 - 1;

		int i = -1, j = 0, length = 1, cnt = 0; // (i, j]
		for (; j < end; ++j, ++length) {
			visited[arr[j]]++; // 먹은 음식 종류 체크
			if (visited[arr[j]] == 1) { // 한번만 먹어본 메뉴라면, 카운트 증가
				++cnt;
				if (visited[c] == 0)
					ans = Math.max(ans, cnt + 1);
				else
					ans = Math.max(ans, cnt);
			}
			if (length >= k) { // k개 만큼 먹었다면, i를 당기기
				++i;
				--length;

				visited[arr[i]]--;
				if (visited[arr[i]] == 0) { // 해당 메뉴가 먹은 음식 중에 없어졌다면, 카운트 감소
					--cnt;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[N * 2 - 1];
		visited = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		System.arraycopy(arr, 0, arr, N, N - 1);

		System.out.println(solution());
	}
}
