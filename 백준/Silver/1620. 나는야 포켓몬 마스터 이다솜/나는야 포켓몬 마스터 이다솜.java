import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(null);

        for (int i = 0; i < n; i++) {
            String name = in.readLine();
            map.put(name, i + 1);
            list.add(name);
        }

        for (int i = 0; i < m; i++) {
            String name = in.readLine();
            try {
                int id = Integer.parseInt(name);
                out.append(list.get(id)).append("\n");
            } catch (NumberFormatException e) {
                out.append(map.get(name)).append("\n");
            }
        }

        System.out.print(out);
    }
}