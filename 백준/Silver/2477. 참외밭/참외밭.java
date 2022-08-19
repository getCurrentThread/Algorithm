
import java.util.Scanner;

public class Main {
	static int K;
	static int R, C;
	static int DR, DC;
	static int arr[][];

	public static int[][] shape = new int[][] { new int[] { 3, 2 }, new int[] { 4, 1 }, new int[] { 1, 3 },
			new int[] { 2, 4 } };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == 1 || arr[i][0] == 2)
				R = Math.max(R, arr[i][1]);
			if (arr[i][0] == 3 || arr[i][0] == 4)
				C = Math.max(C, arr[i][1]);
		}
		outer: for (int k = 0; k < 4; k++) {
			for (int i = 0; i < 6; i++) {
				if (arr[i][0] == shape[k][0] && arr[(i + 1) % 6][0] == shape[k][1]) {
					DR = arr[i][1];
					DC = arr[(i + 1) % 6][1];
					break outer;
				}
			}
		}

		System.out.println((R * C - DR * DC) * K);
	}
}
