import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            if (simulate(br.readLine())) {
                System.out.println(":)");
            } else {
                System.out.println(":(");
            }
        }
    }

    private static boolean simulate(String line) {
        int cards[] = Arrays.stream(line.split(" "))
                .mapToInt(x -> (x.charAt(1) == 'm' ? 10
                        : x.charAt(1) == 'p' ? 20
                        : 30)
                        + x.charAt(0) - '0')
                .sorted().toArray();

        // check the cards is a triple or two pair.
        if (Arrays.stream(cards).distinct().count() <= 2) {
            return true;
        }

        // check the cards is a straight.
        int tCards[] = Arrays.stream(cards).distinct().toArray();
        for (int i = 0; i < tCards.length - 2; i++) {
            if (tCards[i] + 1 == tCards[i + 1] && tCards[i + 1] + 1 == tCards[i + 2]) {
                return true;
            }
        }

        return false;
    }
}