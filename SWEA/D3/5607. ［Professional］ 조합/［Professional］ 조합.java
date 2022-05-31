import java.util.Scanner;

public class Solution {
	static final int P = 1234567891;

	static long nPowsMod(long n, int s) {
		if(s == 0) return 1;
		long temp = nPowsMod(n, s/2);
		temp = temp * temp % P;
		
		if(s % 2 == 0) {
			return temp;
		}else {
			return n * temp % P;
		}
	}

	static long nCrMod(int n, int r) {
		long result = fac[n];
		result *= nPowsMod(fac[n-r], P-2);
		result %= P;
		result *= nPowsMod(fac[r], P-2);
		result %= P;
		return result;
	}

	static long fac[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tcase = sc.nextInt();
		
		//팩토리얼 계산
		fac = new long[1000001];
		fac[0] = 1;
		for (int i = 1; i <= 1000000; i++)
			fac[i] = (fac[i - 1] * i) % P;
		
		for (int t = 1; t <= Tcase; t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			System.out.println("#" + t + " " + nCrMod(N, R));
		}
	}
}
