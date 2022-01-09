import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		int D[][] = new int[N][3];

		// 첫 시작의 상태에 따른 경우의 수를 1로
		D[0][0] = D[0][1] = D[0][2] = 1;
		for (int x = 1; x < N; x++) {
			D[x][0] = (D[x - 1][0] + D[x - 1][1] + D[x - 1][2]) % 9901;
			D[x][1] = (D[x - 1][0] + D[x - 1][2]) % 9901;
			D[x][2] = (D[x - 1][0] + D[x - 1][1]) % 9901;
		}

		// N번째에 해당하는 경우의 수 % 9901
		System.out.println((D[N - 1][0] + D[N - 1][1] + D[N - 1][2]) % 9901);
	}
}