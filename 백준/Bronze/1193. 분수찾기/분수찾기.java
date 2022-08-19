import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int left = 0, right = 1;
        int step = 0;
        while (N-- > 0) {
            left += step;
            right -= step;
            if (left == 0 || right == 0) {
                step = (left + right) % 2 == 0 ? 1 : -1;
                if (left == 0)
                    left = 1;
                else
                    right = 1;
            }
        }
        System.out.println(left + "/" + right);
    }

}