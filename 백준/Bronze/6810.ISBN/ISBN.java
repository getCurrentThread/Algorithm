import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int result = 91
                + Integer.parseInt(in.readLine()) * 1
                + Integer.parseInt(in.readLine()) * 3
                + Integer.parseInt(in.readLine()) * 1;

        System.out.println("The 1-3-sum is " + result);
    }
}
