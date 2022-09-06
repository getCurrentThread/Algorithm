import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(br.readLine()));
    }

    private static String solve(String line) {
        final char[] temp = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<Character>();
        boolean flag = false;
        for (final char ch : line.toCharArray()) {
            switch (ch) {
                case '<':
                    flag = true;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                    break;
                case '>':
                    flag = false;
                    sb.append(ch);
                    break;
                case ' ':
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                    break;
                default:
                    if (flag) {
                        sb.append(ch);
                    } else {
                        stack.push(ch);
                    }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}