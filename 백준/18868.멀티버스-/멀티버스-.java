import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N; // 학급의 개수 M, 각 반의 학생수 N
	static int arr[][]; // 학생들의 점수를 담아두는 배열

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 in 객체 생성.
		StringTokenizer st = new StringTokenizer(in.readLine()); // 첫줄 M N을 잘라서 받기 위한 StringTokenzier 객체 생성
		M = Integer.parseInt(st.nextToken()); // 학급의 개수 M 입력
		N = Integer.parseInt(st.nextToken()); // 각 반의 학생수 N 입력

		arr = new int[M][N]; // 학생들의 점수를 담아둘 배열 크기 M x N 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()); // 각 반의 N명의 학생 성적을 잘라서 받기 위한 StringTokenzier 객체 생성
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); // M학급의 N번 학생의 점수를 배열에 담음
			}
		}

		for (int a = 0; a < M; a++) {
			for (int b = a + 1; b < M; b++) { // 학급 a, b를 서로 비교
				if (checking(arr[a], arr[b])) { // 조건을 충족한다면
					ans++; // 결과값 1 증가
				}
			}
		}

		System.out.println(ans); // 결과 출력
	}

	// a 학급, b학급에 대해서 조건에 주어진 항목을 만족하는지 체크
	public static boolean checking(int[] a, int[] b) {
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int adiff = a[i] - a[j]; // a 학급 학생 i, j끼리 점수 차이
				int bdiff = b[i] - b[j]; // b 학습 학생 i, j끼리 점수 차이
				if (adiff > 0 && bdiff > 0)
					continue; // a,b학급 둘다, i학생이 더 점수가 좋은 경우	-> 계속 비교 진행.
				else if (adiff == 0 && bdiff > 0)
					continue; // a,b학급 둘다, 서로 같은 경우			-> 계속 비교 진행.
				else if (adiff < 0 && bdiff < 0)
					continue; // a,b학급 둘다, j학생이 더 점수가 좋은 경우 	-> 계속 비교 진행.
				return false; // 위의 조건을 만족하지 않으므로 false 반환.
			}
		}
		return true; // 모든 조건을 만족하므로 true 반환.
	}
}
