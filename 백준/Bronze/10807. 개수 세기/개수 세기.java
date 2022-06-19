import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[201];
        while (v-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            arr[x + 100]++;
        }

        int target = Integer.parseInt(in.readLine());
        int ans = arr[target + 100];
        System.out.println(ans);
    }
}