import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new BigInteger(br.readLine());
        }

        int k = solution(arr);
        System.out.println(k);
    }

    private static int solution(BigInteger[] arr) {
        BigInteger tmp = BigInteger.TEN;
        int k = 1;
        while(tmp.compareTo(arr[0]) <= 0) {
            Set<BigInteger> set = new HashSet<>(arr.length);
            for (BigInteger a : arr) {
                if(set.contains(a.mod(tmp)))
                    break;
                set.add(a.mod(tmp));
            }
            if(set.size() == arr.length) {
                return k;
            }
            tmp = tmp.multiply(BigInteger.TEN);
            k++;
        }
        return arr[0].toString().length();
    }
}