import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else { // ')'
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}