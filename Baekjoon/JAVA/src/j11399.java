import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class j11399 {
    static int N;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine().trim());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }
        int sum = 0;
        for(int i =0; i < N; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
