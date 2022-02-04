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
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            out.append("Case #" + t + ": " + A + " + " + B + " = " + (A + B) + "\n");
        }
        System.out.print(out);
    }
}
