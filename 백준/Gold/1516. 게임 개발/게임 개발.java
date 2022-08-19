import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] result = new int[n];
        int[] times = new int[n];
        int[] degree = new int[n];
        for (int cur = 0; cur < n; cur++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            times[cur] = Integer.parseInt(st.nextToken());

            int before;
            while((before = Integer.parseInt(st.nextToken())) != -1) {
                graph.get(before - 1).add(cur);
                degree[cur]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                result[i] = times[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int nxt : graph.get(cur)) {
                degree[nxt]--;
                result[nxt] = Math.max(result[nxt], result[cur] + times[nxt]);
                if (degree[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }

}