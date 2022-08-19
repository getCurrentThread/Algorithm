import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String str = null;
        while(!".".equals(str = in.readLine())){
            Deque<Character> stack = new ArrayDeque<>();
            for(char ch : str.toCharArray()){
                switch(ch){
                    case '(':
                    case '[':
                    case '{':
                        stack.push(ch);
                        break;
                    case ')':
                    case ']':
                    case '}':
                        if(stack.isEmpty()) {
                            stack.push('e');
                            break;
                        }
                        char opposite = stack.pop();
                        if((opposite == '(' && ch == ')')
                                || (opposite == '[' && ch == ']')
                                ||(opposite == '{' && ch == '}'))
                            continue;

                        stack.push('e');
                        break;
                    default:
                        continue;
                }
            }

            // 잘못된 경우 조건 체크
            if(!stack.isEmpty()){
                out.append("no").append("\n");
                continue;
            }
            out.append("yes").append("\n");
        }
        System.out.print(out);
    }
}
