import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> m = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String book = br.readLine();
            m.put(book, m.getOrDefault(book, 0) + 1);
        }

        m.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
                .map(x -> x.getKey())
                .ifPresent(System.out::println);
    }
}