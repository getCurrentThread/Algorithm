
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int a, b;
	static int aArr[], bArr[];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int tmp;
		outter:
		for(int i = 0; i < N; i++) {
			aArr = new int[5];
			bArr = new int[5];
			StringTokenizer st = new StringTokenizer(in.readLine());
			//a 입력
			a = Integer.parseInt(st.nextToken());
			for(int j = 0; j < a; j++) {
				tmp = Integer.parseInt(st.nextToken());
				aArr[tmp]++;
			}
			//b 입력
			st = new StringTokenizer(in.readLine());
			b = Integer.parseInt(st.nextToken());
			for(int j = 0; j < b; j++) {
				tmp = Integer.parseInt(st.nextToken());
				bArr[tmp]++;
			}
			
			for(int k = 4; k > 0; k--) {
				if(aArr[k] < bArr[k]) {
					System.out.println("B");
					continue outter;
				}
				else if(aArr[k] > bArr[k]) {
					System.out.println("A");
					continue outter;
				}
			}
			System.out.println("D");
		}
	}
}
