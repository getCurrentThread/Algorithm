import java.util.Scanner;

public class Main {
	static final int dy[] = {1, 0, -1, 0};
	static final int dx[] = {0, 1, 0, -1};
	public static void main(String[] args) {
		int R, C, K;
		int map[][];
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		map = new int[R+1][C+1];
		int x = 1, y = 1;
		
		if(R*C < K) {
			System.out.println(0);
			return;
		}
		int cnt = 1;
		int i = 0;
		map[x][y] = 1;
		while(cnt != K) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx == 0 || cx == C+1 || cy == 0 || cy == R+1 || map[cy][cx] != 0) {
				i = (i + 1)%4;
				continue;
			}
			x =cx;
			y =cy;
			map[y][x] = ++cnt;
		}
		System.out.println(x + " " + y);
	}
}
