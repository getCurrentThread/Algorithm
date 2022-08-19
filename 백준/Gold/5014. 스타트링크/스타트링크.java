import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int MAX = 1000000;
	static int F, S, G, U, D;
	static int ans;

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[F + 1];

		q.offer(S);
		visited[S] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int ele = q.poll();
				if (ele == G)
					return;
				int nxt;
				if ((nxt = ele + U) <= F && !visited[nxt]) {
					q.offer(nxt);
					visited[nxt] = true;
				}
				if ((nxt = ele - D) >= 1 && !visited[nxt]) {
					q.offer(nxt);
					visited[nxt] = true;
				}
			}
			ans++;
		}

		ans = -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();

		bfs();

		if (ans == -1)
			System.out.println("use the stairs");
		else
			System.out.println(ans);

		sc.close();
	}
}
