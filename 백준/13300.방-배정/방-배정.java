
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int students[][];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		students = new int[7][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			++students[y][s];
		}
		
		int cnt = 0;
		for(int y = 1; y <= 6; y++) {
			for(int s = 0; s <= 1; s++) {
				cnt += students[y][s] / K;
				if(students[y][s] % K != 0) ++cnt;
			}
		}
		System.out.println(cnt);
	}
}
