import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        char ch = (char) in.read();
        if(ch == 'n' || ch == 'N') {
            out.append("Naver D2");
        }else{
            out.append("Naver Whale");
        }
        System.out.println(out);
    }
}