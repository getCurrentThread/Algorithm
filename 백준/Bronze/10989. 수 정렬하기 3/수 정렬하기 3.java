import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10001];

        for (int i = 0; i < N; ++i) {
            ++nums[Integer.parseInt(br.readLine())];
        }

        for (int i = 1; i <= 10000; ++i) {
            int temp = nums[i];
            while (temp-- > 0) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
