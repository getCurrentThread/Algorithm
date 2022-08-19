import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int min = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        min += Integer.parseInt(in.readLine());
        min %= 60 * 24;
        System.out.println(min / 60 + " " + min % 60);
    }
}
