import java.io.*;

public class Main {
    static final int[] vals = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().chars()
                .map(x -> x - 'A')
                .map(x -> vals[x])
                .reduce(0, (a, b) -> (a + b) % 10)
                % 2 == 1) { // 홀수 체크
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }

    }
}
