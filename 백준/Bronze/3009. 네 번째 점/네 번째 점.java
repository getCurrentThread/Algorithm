import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = 0, b = 0;
        StringTokenizer st ;
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(in.readLine());
            a = a ^ Integer.parseInt(st.nextToken());
            b = b ^ Integer.parseInt(st.nextToken());
        }
        System.out.println(String.format("%d %d", a, b));
    }
}
