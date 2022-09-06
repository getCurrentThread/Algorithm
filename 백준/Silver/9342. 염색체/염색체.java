import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String input = br.readLine();
            if (check(input)) {
                bw.write("Infected!");
            } else {
                bw.write("Good");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static boolean check(final String input) {
        return input.matches("^[A-F]?A+F+C+[A-F]?$");
    }
}