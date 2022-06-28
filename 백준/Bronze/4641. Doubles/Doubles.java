import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            if (arr[0] == -1) break;
            Arrays.sort(arr);

            int result = 0;
            for (int i = 1; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] * 2 == arr[j]) {
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }
}