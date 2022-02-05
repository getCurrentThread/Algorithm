import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        boolean memo[] = new boolean[10001];
        for(int i = 1; i <= 10000; i++) {
            int tmp = d(i);
            if(tmp > 10000) continue;
            memo[tmp] = true;
        }
        for(int i = 1; i <= 10000; i++) {
            if(memo[i] == false) {
                out.append(i).append('\n');
            }
        }
        System.out.print(out);
    }

    private static int d(int num) {
        int sum = num;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
