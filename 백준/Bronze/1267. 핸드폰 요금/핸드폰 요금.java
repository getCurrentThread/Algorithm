import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int young = 0, min = 0;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int tmp = Integer.parseInt(st.nextToken());
            young += (1 + tmp / 30) * 10;
            min += (1 + tmp / 60) * 15;
        }

        if (young > min)
            System.out.println("M " + min);
        else if (young < min)
            System.out.println("Y " + young);
        else
            System.out.println("Y M " + young);
    }
}