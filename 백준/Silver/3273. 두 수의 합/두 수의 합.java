import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
input:
9
5 12 7 10 9 1 2 3 11
13

output:
3
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0, end = arr.length - 1;
        int count = 0;

        //two-pointer
        int sum = 0;
        while(start < end){
            sum = arr[start] + arr[end];
            if(sum == X){
                count++;
                start++;
                end--;
            }
            else if(sum < X){
                start++;
            }
            else{
                end--;
            }
        }

        System.out.println(count);
    }
}
