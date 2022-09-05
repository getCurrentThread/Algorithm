import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] chars = new char[5][20];
        for (int i = 0; i < 5; i++) {
            char[] temp = br.readLine().toCharArray();
            System.arraycopy(temp, 0, chars[i], 0, temp.length);
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (chars[i][j] == '\0') continue;
                sb.append(chars[i][j]);
            }
        }

        System.out.println(sb);
    }
}
