import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int Tcase = Integer.parseInt(in.readLine());
        for(int t = 1; t <= Tcase; t++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();
            for(char c: chars){
                for(int i = 0; i < N; i++)
                    out.append(c);
            }
            out.append("\n");
        }
        System.out.print(out);
    }
}
