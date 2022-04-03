import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());

        if(n == 1){
            int tmp = 1;
            while(st.hasMoreTokens() && ++tmp == Integer.parseInt(st.nextToken()));
            if(tmp >= 8){
                System.out.println("ascending");
                return;
            }
        }else if(n == 8){
            int tmp = 8;
            while(st.hasMoreTokens() && --tmp == Integer.parseInt(st.nextToken()));
            if(tmp <= 1){
                System.out.println("descending");
                return;
            }
        }

        System.out.println("mixed");
    }
}