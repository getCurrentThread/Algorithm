import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(solve(n, k, arr));
    }

    private static long solve(int n, int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
        }
        long ret = 0;
        int depth = 0;
        n += k;
        while (!q.isEmpty()) {
            int qSize = q.size();
            if(n < qSize) break;
            n -= qSize;
            ret += qSize * depth;
            while (qSize-- > 0) {
                int pos = q.poll();
                if (!set.contains(pos - 1)) {
                    set.add(pos - 1);
                    q.add(pos - 1);
                }
                if (!set.contains(pos + 1)) {
                    set.add(pos + 1);
                    q.add(pos + 1);
                }
            }
            depth++;
        }
        ret += n * depth;
        return ret;
    }
}