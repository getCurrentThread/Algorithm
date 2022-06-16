import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        char[] a = (new StringBuilder(st.nextToken())).reverse().toString().toCharArray();
        char[] b = (new StringBuilder(st.nextToken())).reverse().toString().toCharArray();

        int n = Math.max(a.length, b.length);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (i < a.length) {
                arr[i] += a[i] - '0';
            }
            if (i < b.length) {
                arr[i] += b[i] - '0';
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            out.append(arr[i]);
        }

        System.out.println(out);
    }
}