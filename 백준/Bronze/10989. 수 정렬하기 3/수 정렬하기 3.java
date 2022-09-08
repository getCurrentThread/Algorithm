import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];

        for (int i = 0; i < N; ++i) {
            ++nums[Integer.parseInt(br.readLine())];
        }

        for (int i = 1; i <= 10000; ++i) {
            int temp = nums[i];
            while (temp-- > 0) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
    }
}
