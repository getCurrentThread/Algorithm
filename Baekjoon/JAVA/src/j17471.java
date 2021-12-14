import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class j17471 {
    static int N;
    static int arr[];
    static int total;
    static List<List<Integer>> graph;

    static int ans = Integer.MAX_VALUE;

    static boolean visited[];

    public static boolean isConnectedA() {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] vsit = new boolean[N + 1];
        int cnt = 0;
        int first = 1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                first = i;
                ++cnt;
            }
        }
        if (cnt <= 1)
            return true;
        q.add(first);
        vsit[first] = true;
        int nCnt = 1;
        while (!q.isEmpty()) {
            for (int i : graph.get(q.poll())) {
                if (!visited[i] && !vsit[i]) {
                    vsit[i] = true;
                    q.add(i);
                    nCnt++;
                }
            }
        }
        if (nCnt == cnt)
            return true;
        else
            return false;
    }

    public static boolean isConnectedB() {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] vsit = new boolean[N + 1];
        int cnt = 0;
        int first = 1;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                first = i;
                ++cnt;
            }
        }
        if (cnt <= 1)
            return true;
        q.add(first);
        vsit[first] = true;
        int nCnt = 1;
        while (!q.isEmpty()) {
            for (int i : graph.get(q.poll())) {
                if (visited[i] && !vsit[i]) {
                    vsit[i] = true;
                    q.add(i);
                    nCnt++;
                }
            }
        }
        if (nCnt == cnt)
            return true;
        else
            return false;
    }

    public static void combination(int depth, int i, int amount) {
        if (depth == N + 1)
            return;

        if (depth == 0) {

            for (; i <= 1 + N / 2; i++) {
                visited[i] = true;
                combination(depth + 1, i + 1, amount + arr[i]);
                visited[i] = false;
            }

            return;
        }

        if (isConnectedA() && isConnectedB()) {
            ans = Math.min(ans, Math.abs(total - 2 * amount));
        }

        for (; i <= N; i++) {
            visited[i] = true;
            combination(depth + 1, i + 1, amount + arr[i]);
            visited[i] = false;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            total += arr[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            List<Integer> list = graph.get(i);
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        combination(0, 1, 0);

        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
