import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        arr = Arrays.stream(arr)
                .distinct()
                .sorted((a, b) -> {
                    int aLen = a.length();
                    int bLen = b.length();
                    if (aLen == bLen) {
                        return a.compareTo(b);
                    } else {
                        return aLen - bLen;
                    }
                })
                .toArray(String[]::new);

        for (String s : arr) {
            System.out.println(s);
        }
    }
}