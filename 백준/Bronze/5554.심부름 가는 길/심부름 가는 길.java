import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum += Integer.parseInt(in.readLine());
        }
        System.out.println(sum / 60);
        System.out.println(sum % 60);
    }
}
