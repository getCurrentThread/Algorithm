import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j15552 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a, b;
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append('\n');
        }
        System.out.println(sb);
    }
}
