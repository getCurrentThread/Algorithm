import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        for(int i = arr[0]; ; i++){
            count = 0;
            for(int j = 0; j < 5; j++){
                if(i % arr[j] == 0){
                    count++;
                }
            }
            if(count >= 3){
                System.out.println(i);
                return;
            }
        }
    }
}