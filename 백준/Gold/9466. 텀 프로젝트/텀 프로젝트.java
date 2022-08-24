import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solve(n, arr));
        }
    }

    private static int solve(int n, int[] arr) {

        List<List<Integer>> graph = makeGraphs(n, arr);
        return findUnicycleCount(n, graph);
    }

    private static int findUnicycleCount(int n, List<List<Integer>> graph) {
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dfs(graph, visited, i);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                ++count;
            }
        }
        return count;
    }

    private static void dfs(List<List<Integer>> graph, int[] visited, int current) {
        if (visited[current] == -1 || visited[current] == 2) { // 이전에 방문했던 노드들
            return;
        }
        ++visited[current];
        for (int next : graph.get(current)) {
            dfs(graph, visited, next);
        }

        // 사이클이 아닌 노드들은 방문 표기
        if (visited[current] < 2) {
            visited[current] = -1;
        }
    }

    private static List<List<Integer>> makeGraphs(int n, int[] arr) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            graph.get(i + 1).add(arr[i]);
        }
        return graph;
    }
}