import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Collections;
import java.util.Vector;

import javax.swing.InputMap;

public class Main {
	static int a[][];
	static int n;
	static Vector<Integer> v;
	static int cnt;
	
	static int [] posX = {-1,0,0,1};
	static int [] posY = {0,-1,1,0};
	
	static void dfs(int x, int y) {
		a[x][y] = 0;
		v.set(cnt, v.get(cnt)+1);

		for (int i = 0; i < 4; i++) {
		int mx = x + posX[i];
		int my = y + posY[i];
		if (0 > mx || n <= mx || 
			0 > my || n <= my || 
			a[mx][my] == 0) continue;

		dfs(mx, my);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new int[n][n];
		v = new Vector<Integer>();
		for (int i = 0; i < n; i++) {
			String row = in.readLine();
			for (int j = 0; j < n; j++) {
				a[i][j] = row.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1){
					v.add(0);
					dfs(i, j);
					cnt++;
				}
			}
		}

		Collections.sort(v);

		System.out.println(cnt);
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}

		return;
	}
}
