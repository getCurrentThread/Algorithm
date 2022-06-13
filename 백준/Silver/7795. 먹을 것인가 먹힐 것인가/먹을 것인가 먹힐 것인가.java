import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            int[] b = new int[M];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++)
                b[i] = Integer.parseInt(st.nextToken());

            // A, B 오름차순 정렬
            Arrays.sort(a);
            Arrays.sort(b);

            int ans = 0;

            int j = M - 1; // B 포인터
            for (int i = N - 1; i >= 0; i--) { // A 포인터
                while (j >= 0 && a[i] <= b[j]) {
                    j--;
                }
                ans += j + 1;
            }

            System.out.println(ans);
        }
    }
}

