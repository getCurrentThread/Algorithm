import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        int[] arr = new int[81];

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    arr[i + j + k]++;
                }
            }
        }

        int mx = 0;
        int result = 1;
        for (int i = 1; i <= 80; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
                result = i;
            }
        }

        System.out.println(result);
    }
}