import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class j2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> s = new Stack<int[]>();
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        for(int i = 1; i <= N; i++) {
            int element = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && s.peek()[0] < element) {
                s.pop();
            }
            if(s.isEmpty()) {
                System.out.print("0 ");
                s.push(new int[]{element, i});
                continue;
            }
            System.out.print(s.peek()[1]);
            s.push(new int[]{element, i});
            System.out.print(' ');
        }
    }
}
