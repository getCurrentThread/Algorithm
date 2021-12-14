import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class j13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
//        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            arr[i] -= B;
        }
        long ans = N;
        Arrays.sort(arr);
        for (int i = N - 1; i >= 0; i--) {
            if(arr[i] <= 0) break;

            if(arr[i] % C == 0)
                ans += arr[i] / C;
            else
                ans += arr[i] / C + 1;
        }

        System.out.println(ans);
    }
}