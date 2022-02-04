import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());

        int mx = 0;
        int score = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            mx = Math.max(mx, tmp);
            score += tmp;
        }

        System.out.println(score * 100  / (double) (N*mx) );
    }
}
