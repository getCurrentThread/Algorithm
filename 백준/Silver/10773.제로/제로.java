import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(in.readLine());

        int i;
        while(N-- > 0) {
            i = Integer.parseInt(in.readLine());
            if(i == 0)
                stack.pop();
            else
                stack.push(i);
        }
        int ans = 0;
        for(int j : stack){
            ans += j;
        }
        System.out.println(ans);
    }
}