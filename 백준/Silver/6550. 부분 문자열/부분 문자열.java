import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            if (isSubSequence(a, b)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

    private static boolean isSubSequence(String a, String b) {
        if (a.length() < b.length()) return isSubSequence(b, a);
        //length always a >= b...
        char[] arrB = b.toCharArray();

        int idx = -1;
        for (int i = 0; i < arrB.length; i++) {
            idx = a.indexOf(arrB[i], idx + 1);
            if (idx < 0) return false;
        }
        return true;
    }
}
