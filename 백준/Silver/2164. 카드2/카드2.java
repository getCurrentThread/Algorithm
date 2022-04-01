import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        Deque<Integer> deque = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }
        while (deque.size() > 1) {
            deque.pollFirst(); // 가장 위의 카드를 뽑고
            deque.offerLast(deque.pollFirst());
        }
        int result = deque.poll();
        System.out.println(result);
    }
}