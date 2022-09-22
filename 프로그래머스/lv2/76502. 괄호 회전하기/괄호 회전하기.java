import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(sb.toString()))
                ++answer;
            sb.append(sb.charAt(0)).deleteCharAt(0);
        }
        return answer;
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.peek() != map.get(ch)) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}