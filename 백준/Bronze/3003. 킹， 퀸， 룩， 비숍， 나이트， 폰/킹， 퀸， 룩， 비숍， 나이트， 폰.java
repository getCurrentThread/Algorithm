import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int arr[] = {1, 1, 2, 2, 2, 8};

        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < arr.length; i++){
            out.append(arr[i] - Integer.parseInt(st.nextToken()) + " ");
        }
        System.out.println(out);
    }
}
