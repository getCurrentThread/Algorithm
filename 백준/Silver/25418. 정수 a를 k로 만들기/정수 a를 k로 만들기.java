import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ret = solve(A, K);
        System.out.println(ret);
    }

    private static int solve(int start, int end) {
        boolean[] visited = new boolean[MAX_N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;

        int depth = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            while (qSize-- > 0) {
                int cur = q.poll();
                if (cur == end) {
                    return depth;
                }
                // cur * 2
                if (cur * 2 <= end && !visited[cur * 2]) {
                    q.add(cur * 2);
                    visited[cur * 2] = true;
                }
                // cur + 1
                if (cur + 1 <= end && !visited[cur + 1]) {
                    q.add(cur + 1);
                    visited[cur + 1] = true;
                }
            }
            depth++;
        }
        return -1;
    }
}