import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}