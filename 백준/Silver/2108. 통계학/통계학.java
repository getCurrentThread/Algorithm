import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        System.out.println(average(arr));
        System.out.println(middle(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));
    }

    private static int range(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }

    private static int mode(int[] arr) {
        int[] count = new int[8001];
        for (int i = 0; i < arr.length; i++) {
            count[4000 + arr[i]]++;
        }

        int mx = 0;
        for (int i = 0; i <= 8000; i++) {
            if (count[i] > mx) {
                mx = count[i];
            }
        }

        int result = 0;
        int cnt = 2;
        for(int i = 0; i <= 8000; i++) {
            if (count[i] == mx) {
                if(--cnt <= 0){
                    return i - 4000;
                }
                result = i - 4000;
            }
        }

        return result;
    }

    private static int middle(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    private static int average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (int) Math.round(sum / (double) arr.length);
    }
}