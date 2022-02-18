import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());

        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += square(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sum % 10);
    }

    private static int square(int n) {
        return n * n;
    }
}
