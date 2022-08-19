import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt; // 듣도 못한 사람 N , 보도 못한 사람 M
    static StringTokenizer st;
    static BufferedReader br;
    static StringBuilder sb;
    static String[] A, B;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N + 1];
        B = new String[M + 1];

        inputA();
        inputB();

        for (int i = 1; i <= N; i++) {
            logic(A[i]);
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void inputA() throws IOException {
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = st.nextToken();
        }
        Arrays.sort(A, 1, N + 1);
    }

    public static void inputB() throws IOException {
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            B[i] = st.nextToken();
        }
        Arrays.sort(B, 1, M + 1);
    }

    public static void logic(String str) {

        int L = 1;
        int R = B.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (B[mid].equals(str)) {
                cnt++;
                sb.append(str).append('\n');
                break;
                // 이부분이 킥
            } else if (B[mid].compareTo(str) <= 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
    }
}