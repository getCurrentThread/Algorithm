import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int Tcase = sc.nextInt();
		for(int t = 1; t<= Tcase; t++) {
			int N = sc.nextInt();
			int sum = 0;
			int arr[] = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			double average = ((double) sum) / N;
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				if(average >= arr[i]) ans++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}