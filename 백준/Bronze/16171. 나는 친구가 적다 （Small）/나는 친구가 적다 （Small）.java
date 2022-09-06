import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String source = br.readLine();
        String target = br.readLine();

        if (check(source, target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean check(final String source, final String target) {
        return source.replaceAll("[0-9]", "").contains(target);
    }

}
