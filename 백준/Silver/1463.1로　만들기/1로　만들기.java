import java.util.Scanner;

public class Main {
	static int memo[];
	static int N;
	
	public static int dp(int n) {
		if(n <= 1) return 0;
		if(memo[n] != 0) return memo[n];
		int mn = Integer.MAX_VALUE;
		if(n % 3 == 0) mn = Math.min(mn, dp(n/3) + 1);
		if(n % 2 == 0) mn = Math.min(mn, dp(n/2) + 1);
		mn = Math.min(mn, dp(n-1) + 1);
		return memo[n] = mn;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new int[N+1];
		for(int i = 2; i < N; i++) {
			dp(i);
		}
		System.out.println(dp(N));
	}
}
