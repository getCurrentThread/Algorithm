import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[n];
        System.out.println(dfs(arr, visited, 0, 0, 0));
        int ans = 0;
    }

    static int mx = 0;

    static int dfs(int[] arr, boolean[] visited, int depth, int prev, int sum) {
        if (depth == arr.length) {
            mx = Math.max(mx, sum);
            return mx;
        }
        if (depth == 0) {
            for (int i = 0; i < arr.length; i++) {
                visited[i] = true;
                dfs(arr, visited, 1, i, 0);
                visited[i] = false;
            }
            return mx;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(arr, visited, depth + 1, i, sum + Math.abs(arr[i] - arr[prev]));
            visited[i] = false;
        }

        return mx;
    }
}