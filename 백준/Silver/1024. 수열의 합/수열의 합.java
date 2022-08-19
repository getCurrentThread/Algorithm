import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // x + (x + 1) + (x + 2) + ... + (x + L - 1) = N
        // -> N = L*x + (1+2+...+L-1)
        // -> x = (N - (1+2+...+L-1)) / L (but, L is not constant, 2 <= L <= 100)

        // find 'x' such that x = tmp_x / l, ( L <= i <= 100 )
        for (int l = L; l <= 100; l++) {
            // tmp_x = (N - (1+2+...+L-1));
            int temp = (N - sumRange(l - 1));
            if (temp % l != 0) continue; // not divisible... (try next l)

            // 3. if found, print x, x+1, x+2, ..., x+L-1
            int x = temp / l;
            if(x < 0) continue; // negative integer is invalid. (try next l)
            for (int j = 0; j < l; j++) {
                System.out.print(x + j + " ");
            }
            return;
        }
        System.out.println("-1");
    }

    private static int sumRange(int n) {
        return (int) ((n * (n + 1L)) / 2);
    }
}