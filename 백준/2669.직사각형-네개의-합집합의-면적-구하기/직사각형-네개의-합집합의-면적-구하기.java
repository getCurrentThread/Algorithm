
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean arr[][] = new boolean[101][101];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int x = x1; x < x2; ++x) {
				for(int y = y1; y < y2; ++y) {
					arr[x][y] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				if(arr[i][j]) ++cnt;
			}
		}
		System.out.println(cnt);
	}
}
