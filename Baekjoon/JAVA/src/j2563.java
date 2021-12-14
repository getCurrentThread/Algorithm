
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j2563 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        boolean arr[][] = new boolean[100][100];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int dx = 0; dx < 10; dx++) {
                for(int dy = 0; dy < 10; dy++) {
                    arr[dx+x][dy+y] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(arr[i][j]) ++ans;
            }
        }

        System.out.println(ans);
    }
}
