import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int current = Arrays.stream(in.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .reduce(0, (left, right) -> left * 60 + right);
        int scheduled = Arrays.stream(in.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .reduce(0, (left, right) -> left * 60 + right);

        int waitingTime = scheduled - current > 0 ? scheduled - current : 24 * 3600 + (scheduled - current);
        System.out.printf("%02d:%02d:%02d\n", waitingTime / 3600, waitingTime / 60 % 60, waitingTime % 60);
    }
}
