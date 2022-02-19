import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        in.readLine(); //pass 1 line.
        BigInteger a = new BigInteger(in.readLine());
        BigInteger b = new BigInteger(in.readLine());

        System.out.println(a.multiply(b));
    }
}
