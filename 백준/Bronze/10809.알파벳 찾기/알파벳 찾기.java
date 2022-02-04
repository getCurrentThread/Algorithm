import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int[] arr = new int['z' - 'a' + 1];
        Arrays.fill(arr, -1);

        char[] chars = in.readLine().toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(arr[chars[i] - 'a'] == -1)
                arr[chars[i] - 'a'] = i;
        }

        for(int i = 0; i < arr.length; i++) {
            out.append(arr[i]).append(' ');
        }
        System.out.print(out);
    }
}
