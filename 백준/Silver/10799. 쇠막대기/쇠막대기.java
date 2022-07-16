import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line = br.readLine().toCharArray();

        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == '(') {
                stack.push(i);
            } else if (line[i] == ')') {
                int start = stack.pop();
                int end = i;
                if (end - start == 1) {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}