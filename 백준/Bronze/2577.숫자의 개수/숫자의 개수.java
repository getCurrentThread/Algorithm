import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(in.readLine());
        int B = Integer.parseInt(in.readLine());
        int C = Integer.parseInt(in.readLine());
        int[] arr = new int[10];
        int tmp = A * B * C;
        while(tmp > 0) {
            arr[tmp % 10]++;
            tmp /= 10;
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
