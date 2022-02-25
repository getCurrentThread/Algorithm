import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(arr[i]);
            }

            int[] tmp = set.stream().mapToInt(Integer::intValue).sorted().toArray();
            for (int i = 0; i < tmp.length; i++) {
                map.put(tmp[i], i);
            }
        }

        for(int i = 0; i < n; i++) {
            out.append(map.get(arr[i])).append(" ");
        }
        System.out.print(out);
    }
}