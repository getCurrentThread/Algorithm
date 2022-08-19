import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int pack = Math.min(arr[0][0], arr[0][1] * 6);
        int piece = arr[0][1];
        for (int i = 1; i < m; i++) {
            pack = Math.min(pack, Math.min(arr[i][0], arr[i][1] * 6));
            piece = Math.min(piece, arr[i][1]);
        }
        int result = (n % 6 == 0) ? pack * (n / 6) : Math.min(pack * (n / 6 + 1), pack * (n / 6) + piece * (n % 6));
        System.out.println(result);
    }
}
