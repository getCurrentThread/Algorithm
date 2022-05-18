import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr)
                .map(a -> a % 7)
                .filter(a -> a != 0)
                .toArray();

        // 선행검사로 금요일로 바로 갈 수 있는 경우를 확인해본다.
        if (Arrays.stream(arr).anyMatch(a -> a == 4)) {
            System.out.println("YES");
            return;
        }

        // dfs로 모두 순회하며 가능성을 찾아본다.
        if (dfs(arr, 0, 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean dfs(int[] arr, int cur, int sum) {
        if (sum == 4)
            return true;

        for (int i = cur; i < arr.length; i++) {
            if (dfs(arr, i + 1, (sum + arr[i]) % 7)
                    || dfs(arr, i + 1, sum))
                return true;
        }
        return false;
    }
}