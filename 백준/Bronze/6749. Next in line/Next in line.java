import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());

        System.out.println((b << 1) - a);
    }
}
