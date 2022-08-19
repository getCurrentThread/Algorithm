import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static final int MAX = 100000;
	static int mn = Integer.MAX_VALUE;

	static class Loc implements Cloneable {
		int x;
		int sec;

		public Loc(int x, int sec) {
			this.x = x;
			this.sec = sec;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	public static void bfs() throws Exception {
		Queue<Loc> q = new LinkedList<Loc>();
		boolean[] visited = new boolean[MAX + 1];
		Loc tmp = new Loc(N, 0);

		mn = Math.abs(N - K);
		q.offer(tmp);
		visited[tmp.x] = true;
		while (!q.isEmpty()) { // 뒤로 1칸, 앞으로 1칸, x*2로 가는 생각.
			tmp = q.poll();

			if (tmp.x > K) { // 동생보다 x 좌표가 넘는 경우
				mn = Math.min(mn, tmp.x - K  + tmp.sec);
			} else if (tmp.x == K) {// 같은 경우 갱신 후, break
				mn = Math.min(mn, tmp.sec);
				break;
			}

			Loc ltmp = (Loc) tmp.clone();
			do { // x*2
				ltmp.x *= 2;
				if (ltmp.x <= MAX && !visited[ltmp.x]) {
					visited[ltmp.x] = true;
					q.offer(new Loc(ltmp.x, ltmp.sec));
				}
			} while (ltmp.x != 0 && ltmp.x < K);

			if (tmp.x + 1 <= MAX && !visited[tmp.x + 1]) {// x+1
				visited[tmp.x+1] = true;
				q.offer(new Loc(tmp.x+1, tmp.sec+1));
			}
			if (tmp.x - 1 >= 0 && !visited[tmp.x - 1]) {// x-1
				visited[tmp.x-1] = true;
				q.offer(new Loc(tmp.x-1, tmp.sec+1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs();

		System.out.println(mn);
	}
}
