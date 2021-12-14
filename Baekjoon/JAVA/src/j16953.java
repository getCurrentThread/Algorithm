import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class j16953 {
    static int A, B;

    static class Node {
        long num;

        public Node(long num) {
            this.num = num;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int ans = bfs(A, B);
        System.out.println(ans);
    }

    private static int bfs(final long a, final long b) {

        //기저조건 : A와 B가 서로 같은 경우는 연산할 필요가 없으므로 0반환
        if(a == b) return 0;
        // BFS
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(a));

        int times = 1; // 연산 횟수
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Node node = q.poll();
                if (node.num > b) //넘어가는 경우 pass
                    continue;
                else if (node.num == b) { //같은 경우 연산 횟수 반환.
                    return times;
                }
                q.offer(new Node(node.num * 2));
                q.offer(new Node(node.num * 10 + 1));
            }
            times++;
        }
        return -1;
    }
}