import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb;
        while (!(sb = new StringBuilder(in.readLine())).toString().equals("END")) {
            bw.write(sb.reverse().toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
