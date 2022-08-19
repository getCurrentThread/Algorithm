import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken().trim();
        String B = st.nextToken().trim();

        long result = weirdMultiply(A, B);

        System.out.println(result);
    }

    private static long weirdMultiply(String a, String b) {
        int[] arrA = a.chars().map(c -> c - '0').toArray();
        int[] arrB = b.chars().map(c -> c - '0').toArray();

        long result = 0;
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrB.length; j++) {
                result += arrA[i] * arrB[j];
            }
        }

        return result;
    }
}