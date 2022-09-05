import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Map<Integer, Long> result = br.readLine().chars()
                    .filter(value -> value != ' ')
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            List<Map.Entry<Integer, Long>> entries = result.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                    .limit(2).collect(Collectors.toList());
            if (entries.size() == 1 || entries.stream().map(Map.Entry::getValue).distinct().count() > 1) {
                System.out.println((char) entries.get(0).getKey().intValue());
            } else {
                System.out.println('?');
            }
        }
    }
}
