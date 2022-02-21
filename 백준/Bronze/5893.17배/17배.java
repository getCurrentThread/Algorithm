import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        BigInteger a = new BigInteger(in.readLine(), 2);
        System.out.println(a.multiply(BigInteger.valueOf(17)).toString(2));
    }
}
