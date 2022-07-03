import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = {1, 1, 2, 6, 4, 0};
        System.out.println(n >= 5? arr[5] : arr[n]);
    }
}