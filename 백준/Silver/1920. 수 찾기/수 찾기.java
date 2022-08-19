import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(in.readLine());

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < M; i++){
            int K = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(arr, K) >= 0){
                out.append("1\n");
            }else{
                out.append("0\n");
            }
        }
        System.out.print(out);
    }
}
