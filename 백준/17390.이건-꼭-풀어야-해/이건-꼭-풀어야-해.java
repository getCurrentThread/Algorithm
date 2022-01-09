import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();


        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int arr[]    = new int[N+1];

        st = new StringTokenizer(in.readLine());
        for(int i = 1; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //누적합으로 변경
        for(int i = 1; i <= N; i++){
            arr[i] += arr[i-1];
        }

        int l, r;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(in.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            out.append(arr[r] - arr[l-1]).append('\n');
        }
        System.out.print(out);
    }
}
