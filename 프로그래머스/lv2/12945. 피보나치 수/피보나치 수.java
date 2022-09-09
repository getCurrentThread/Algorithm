import java.util.*;

class Solution {
    static final int MOD = 1234567;

    public int solution(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        q.offer(1);
        while (n-- > 0) {
            q.offer((q.poll() + q.peek()) % MOD);
        }
        return q.peek();
    }
}