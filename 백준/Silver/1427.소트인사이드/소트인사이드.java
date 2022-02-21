import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        char[] arr = in.readLine().toCharArray();
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--){
            out.append(arr[i]);
        }
        System.out.println(out);
    }
}
