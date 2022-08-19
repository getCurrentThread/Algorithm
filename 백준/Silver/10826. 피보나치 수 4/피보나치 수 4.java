import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        System.out.println(fibo(n));
    }


    private static BigInteger fibo(int n) {
        if(n == 0) return BigInteger.ZERO;
        else if(n == 1) return BigInteger.ONE;

        Queue<BigInteger> queue = new ArrayDeque<>(3);
        queue.add(BigInteger.ZERO);
        queue.add(BigInteger.ONE);

        for (int i = 2; i <= n; i++) {
            BigInteger first = queue.poll();
            BigInteger second = queue.peek();
            queue.add(first.add(second));
        }
        queue.poll();
        return queue.poll();
    }
}