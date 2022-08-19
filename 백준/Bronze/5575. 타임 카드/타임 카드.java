import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            h = Integer.parseInt(st.nextToken()) - h;
            m = Integer.parseInt(st.nextToken()) - m;
            s = Integer.parseInt(st.nextToken()) - s;

            s = h * 3600 + m * 60 + s;
            System.out.println(s / 3600 + " " + (s % 3600) / 60 + " " + s % 60);
        }
    }
}
