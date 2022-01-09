import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] sw = new int[N];
		for (int i = 0; i < N; i++) {
			sw[i] = sc.nextInt();
		}

		int stuCnt = sc.nextInt();
		for (int i = 1; i <= stuCnt; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			switch (gender) {
			case 1:// 남
				for (int j = num; j <= N; j += num) {
					sw[j - 1] = sw[j - 1] == 1 ? 0 : 1;
				}
				break;
			case 2:// 여
				int s = num - 1;
				int e = num - 1;
				sw[num - 1] = sw[num - 1] == 1 ? 0 : 1;
				while (s >= 0 && e < N && sw[s] == sw[e]) {
					sw[s] = sw[s]== 1 ? 0 : 1;
					sw[e] = sw[e] == 1 ? 0 : 1;
					s--;
					e++;
				}
				break;
			}

		}
		for (int i = 0; i < sw.length; i++) {
			System.out.print(sw[i]);
			if(i != sw.length-1)
				System.out.print(" ");
			if(i % 20 == 19)
				System.out.println();
		}
	}
}
