import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(in.readLine());
        System.out.printf("%.6f\n", r * r * Math.PI);
        System.out.printf("%.6f\n", r * r * 2.);

    }
}
