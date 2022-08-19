import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        BigInteger n = new BigInteger(in.readLine());

        System.out.println(n.multiply(BigInteger.valueOf(4)));
    }
}
