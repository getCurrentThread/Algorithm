import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int Tcase = Integer.parseInt(in.readLine());
        for(int t = 1; t <= Tcase; t++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.printf("Case #%d: %d\n", t, A+B);
        }
    }
}