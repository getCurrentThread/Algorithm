import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char ch : br.readLine().toCharArray()) {
            if ('a' <= ch && 'z' >= ch)
                bw.write(ch - 'a' + 'A');
            else
                bw.write(ch - 'A' + 'a');
        }

        bw.flush();
        bw.close();
    }
}
