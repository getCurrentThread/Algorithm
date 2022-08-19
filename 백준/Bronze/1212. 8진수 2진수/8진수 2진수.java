import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final String[] bin = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            out.append(bin[input.charAt(i) - '0']);
        }
        System.out.println(out.indexOf("1") != -1? out.substring(out.indexOf("1")) : "0");
    }
}
