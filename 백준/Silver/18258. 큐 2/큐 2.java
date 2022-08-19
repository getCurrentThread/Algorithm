import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        Deque<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            switch (st.nextToken()) {
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        out.append("-1\n");
                    } else {
                        out.append(q.poll() + "\n");
                    }
                    break;
                case "size":
                    out.append(q.size() + "\n");
                    break;
                case "empty":
                    out.append(q.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        out.append("-1\n");
                    } else {
                        out.append(q.peek() + "\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        out.append("-1\n");
                    } else {
                        out.append(q.peekLast() + "\n");
                    }
                    break;
            }
        }

        System.out.print(out);
    }
}