import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("#")) {
            int result = line.toLowerCase().chars()
                    .reduce(0, (a, b) -> isVovel((char) b) ? (a + 1) : a);
            System.out.println(result);
        }


    }

    static boolean isVovel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}