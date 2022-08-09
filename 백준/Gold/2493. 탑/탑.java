import java.io.*;
import java.util.*;

/*
Input:
5
6 9 5 7 4

Output:
0 0 2 2 4
*/
public class Main {
    static class Node {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) { // i = 1 to n
            int x = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().val < x) { // 기존의 탑이 작다면, 이 보다 큰 타워가 나올 때까지 모두 뺀다.
                stack.pop();
            }

            if (stack.isEmpty()) { // 현재의 x층 탑보다 큰 값이 stack 내에 없다면 0을 출력
                out.append(0).append(' ');
            } else { // 현재의 x층 탑보다 큰 값이 stack 내에 있다면, 그 값의 idx를 출력
                out.append(stack.peek().idx).append(' ');
            }

            stack.push(new Node(x, i)); // 새로운 탑을 추가한다. (스택에 남아있는 탑은 내림차순과 같은 구조가 된다.)
        }
        System.out.print(out);
    }
}