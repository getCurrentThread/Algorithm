import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int mx = 0;
        int n = Integer.parseInt(in.readLine());
        while(n-- > 0){
            String input = in.readLine();
            // count text inner r"(for|while)"
            int count = 0;
            Matcher m = Pattern.compile("(for|while)").matcher(input);
            while(m.find()){
                count++;
            }
            mx = Math.max(mx, count);
        }
        System.out.println(mx);
    }
}
