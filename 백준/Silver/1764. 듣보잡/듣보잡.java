import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 14348907;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            set.add(in.readLine());
        }

        List<String> names = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = in.readLine();
            if (set.contains(name)) {
                names.add(name);
            }
        }

        Collections.sort(names);
        System.out.println(names.size());
        for (String name : names) {
            System.out.println(name);
        }
    }
}