import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        if(N == 1)
            return;
        for(int i = 2; i <= N; ){
            if(N % i == 0){
                N /= i;
                System.out.println(i);
                continue;
            }
            i++;
        }
    }
}