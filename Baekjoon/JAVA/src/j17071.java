import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class j17071 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(solve(N, K));
    }

    private static int solve(int n, int k) {
        Deque<Integer> q = new ArrayDeque<Integer>(500001);
        q.offer(n);
        int[] visited = new int[500001];
        Arrays.fill(visited, -1);
        int sec = 0;
        int pos;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                pos = q.poll();
                if (k == pos)
                    return sec;
                if (pos > 0 && visited[pos - 1] != sec) {
                    visited[pos - 1] = sec;
                    q.add(pos - 1);
                }
                if (pos < 500000 && visited[pos + 1] != sec) {
                    visited[pos + 1] = sec;
                    q.add(pos + 1);
                }
                if (pos <= 250000 && visited[pos * 2] != sec) {
                    visited[pos * 2] = sec;
                    q.add(pos * 2);
                }
            }
            k += ++sec;
            if (k > 500000)
                return -1;
        }
        return -1;
    }
}