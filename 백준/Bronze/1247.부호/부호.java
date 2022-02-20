import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        for (int t = 1; t <= 3; t++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(br.readLine());
            }
            Arrays.sort(arr);

            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < arr.length; i++) {
                sum = sum.add(BigInteger.valueOf(arr[i]));
            }

            int sig = sum.signum();
            if(sig == 0) {
                out.append("0\n");
            }else if(sig > 0){
                out.append("+\n");
            }else{
                out.append("-\n");
            }
        }
        System.out.print(out);
    }
}
