import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int arr[];
	static final int MAX = 9;
	static int answer[];
	static final int MMAX = 7;
	
	
	public static boolean dfs(int depth, int nxt, int sum) {
		if(sum > 100)
			return false;
		else if(depth == MMAX) {
			if(sum == 100) {
			return true;
			}
			return false;
		}
		for(int i = nxt; i < MAX; i++) {
			if(dfs(depth+1, i+1, sum+arr[i])) {
				answer[depth] = arr[i];
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[MAX];
		for(int i = 0; i < MAX; i++) {
			arr[i] = sc.nextInt();
		}
		answer = new int[MMAX];
		
		dfs(0, 0, 0);
		
		Arrays.sort(answer);
		for(int i = 0; i < MMAX; i++) {
			System.out.println(answer[i]);
		}
	}
}
