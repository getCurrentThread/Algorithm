import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int Tcase = Integer.parseInt(in.readLine());
        for(int t = 1; t <= Tcase; t++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int room = (int) Math.ceil(N / (double) H);
            room += (N % H  != 0? N % H: H) * 100;
            out.append(room).append('\n');
        }
        System.out.print(out);
    }
}
