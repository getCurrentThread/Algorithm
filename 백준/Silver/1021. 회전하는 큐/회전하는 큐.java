import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(arr, n, m));
    }

    private static int solve(int[] arr, int len, int m) {
        int ret = 0;
        int pos = 0;

        for (int i = 0; i < m; i++) --arr[i];

        for (int i = 0; i < m; i++) {
            int target = arr[i];

            // 최소 이동량 추가
            ret += Math.min(Math.abs(target - pos), len - Math.abs(target - pos));

            // 요소 조정
            pos = target;
            for (int j = i + 1; j < m; j++) {
                if (target < arr[j]) --arr[j];
            }
            --len;
        }
        return ret;
    }
}

