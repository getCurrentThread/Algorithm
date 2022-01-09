import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());
		System.out.println(solve(n));
	}

	final static int[] nums = { 1, 5, 10, 50 };

	private static int solve(final int N) {
		Deque<Integer> q = new ArrayDeque<Integer>(1000);
		int[] visited = new int[1001];

		for (int i = 0; i < nums.length; i++)
			q.add(nums[i]);

		int val, tmp;
		int count = 0;
		while (++count < N) {
			int size = q.size();
			while (size-- > 0) {
				val = q.poll();
				for (int i = 0; i < nums.length; i++) {
					if (visited[tmp = val + nums[i]] != count) {
						visited[tmp] = count;
						q.add(tmp);
					}
				}
			}
		}

		return q.size();
	}
}