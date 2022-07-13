import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] result = solution(n, m);
        for (int i = 0; i < result.length;) {
            for (int j = 0; j < 10 && i < result.length; j++, i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }

    static final String[] digits = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    static class Node implements Comparable<Node> {
        int value;
        String digit;

        Node(int value) {
            this.value = value;
            StringBuilder sb = new StringBuilder();
            while (value > 0) {
                sb.insert(0, digits[value % 10] + " ");
                value /= 10;
            }
            this.digit = sb.toString();
        }

        @Override
        public int compareTo(Node o) {
            return this.digit.compareTo(o.digit);
        }
    }

    private static int[] solution(int from, int to) {
        Node[] nodes = new Node[to - from + 1];
        for (int i = from; i <= to; i++) {
            nodes[i - from] = new Node(i);
        }
        Arrays.sort(nodes);
        int[] result = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            result[i] = nodes[i].value;
        }
        return result;
    }
}