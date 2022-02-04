import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st2.nextToken());
            if (tmp < X){
                out.append(tmp + " ");
            }
        }
        System.out.print(out);
    }
}
