import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0, end = N - 1;
        int left = -1, right = -1;
        int mn = 2000000001;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (mn > Math.abs(sum)) {
                mn = Math.abs(sum);
                left = arr[start];
                right = arr[end];
            }
            if (sum > 0) {
                end--;
            } else if (sum < 0) {
                start++;
            } else if (sum == 0) {
                break;
            }
        }

        System.out.println(left + " " + right);
    }
}
