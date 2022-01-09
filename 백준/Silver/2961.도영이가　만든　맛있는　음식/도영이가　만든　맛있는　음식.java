import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int[n][2];
		for(int i = 0; i < n; i ++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int cycle = 1 << n;
		int mn  = Integer.MAX_VALUE;
		for(int i = 1; i < cycle; i++) {
			int s = 1, b = 0;
			for(int j = 0; j < n; j++) {
				if((i&(1<<j)) != 0) {
					s *= arr[j][0];
					b += arr[j][1];
				}
			}
			mn = Math.min(mn, Math.abs(s-b));
		}
		System.out.println(mn);
	}
}
