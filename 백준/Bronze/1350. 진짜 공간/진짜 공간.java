import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cluster = Integer.parseInt(br.readLine());

        long ret = solve(n, arr, cluster);
        System.out.println(ret);
    }

    private static long solve(int n, int[] arr, int cluster) {
        long size = 0;
        for (int i = 0; i < n; i++) {
            size += (arr[i] / cluster + (arr[i] % cluster == 0 ? 0 : 1)) * (long) cluster;
        }
        return size;
    }
}
