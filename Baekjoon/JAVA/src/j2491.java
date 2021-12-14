import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int arr[] = new int[N];
        int dArr[] = new int[N], sArr[] = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mn, mx;
        mn = mx = arr[0];
        sArr[0] = dArr[0] = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= mn) {
                sArr[i] = sArr[i-1] + 1;
            } else {
                sArr[i] = 1;
            }
            mn = arr[i];
            if (arr[i] >= mx) {
                dArr[i] = dArr[i-1] + 1;
            } else {
                dArr[i] = 1;
            }
            mx = arr[i];
        }
        int answer = 0;
        for(int i  = 0; i < N; i++) {
            answer = Math.max(answer, sArr[i]);
            answer = Math.max(answer, dArr[i]);
        }

        System.out.println(answer);
    }
}
