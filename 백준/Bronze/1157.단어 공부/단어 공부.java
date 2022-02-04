import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        char ch;
        int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int['z' - 'a' + 1];
        in.readLine().toLowerCase(Locale.ROOT).chars().forEach(c -> arr[c - 'a']++);

        Node[] tmp = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = new Node((char) ('A' + i), arr[i]);
        }
        Arrays.sort(tmp);
        if (tmp.length >= 2 && tmp[0].count == tmp[1].count)
            System.out.println("?");
        else
            System.out.println(tmp[0].ch);
    }
}
