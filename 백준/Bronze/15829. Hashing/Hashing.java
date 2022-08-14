import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(in.readLine());
        String str = in.readLine();
        System.out.println(hash(str));
    }

    static final long M = 1234567891;
    static final long r = 31;

    private static long hash(String str) {
        long ret = 0;
        char val[] = str.toCharArray();

        for (int i = val.length - 1; i >= 0; i--) {
            ret = (r * ret + val[i] - 'a' + 1) % M;
        }
        return ret;
    }
}