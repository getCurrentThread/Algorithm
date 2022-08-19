import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> result = solution(n, k);
        out.append('<');
        for (int i = 0; i < result.size() - 1; i++) {
            out.append(result.get(i)).append(", ");
        }
        out.append(result.get(result.size() - 1)).append('>');
        System.out.println(out);
    }

    private static List<Integer> solution(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<Integer> result = new ArrayList<>(n);
        
        int index = 0;
        while(list.size() != 0){
            index = (index + k - 1) % list.size();
            result.add(list.remove(index));
        }
        return result;
    }
}