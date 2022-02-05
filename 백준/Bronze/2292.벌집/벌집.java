import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        long N = Long.parseLong(in.readLine());

        long sum = 1;
        long loop = 1;
        while(sum < N){
            sum += loop * 6;
            loop++;
        }
        System.out.println(loop);
    }
}
