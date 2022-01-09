import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int [][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Queue<int[]> q = new LinkedList<int[]> ();
		int mx = 0;
		q.offer(new int[] {0, 0});
		while(!q.isEmpty()) {
			int [] ele = q.poll();
			if(ele[0] > n) continue;
			else if(ele[0] == n) {
				mx = Math.max(mx, ele[1]);
				continue;
			}
			mx = Math.max(mx, ele[1]); //최댓값 확인
			q.offer(new int[] {ele[0]+1, ele[1]}); //해당 일을 안하고 넘김
			q.offer(new int[] {ele[0]+ arr[ele[0]][0], ele[1] + arr[ele[0]][1]}); //일을 하고 넘김
		}
		System.out.println(mx);
	}
}
