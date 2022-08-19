import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int sum = 0;
        for(int i = 0; i < 5; i++){
            int tmp = Integer.parseInt(in.readLine());
            sum += tmp < 40 ? 40 : tmp;
        }

        System.out.println(sum / 5);
    }
}
