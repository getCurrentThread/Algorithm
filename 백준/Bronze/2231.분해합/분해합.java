import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for(int i = 0; i <= N; i++){
            if(d(i) == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    private static int d(int i) {
        int sum = i;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
