import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while (n-- > 0) {
            list.add(br.readLine());
        }
        Map<String, Long> ret = solve(list);
        for (Map.Entry<String, Long> data : ret.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList())) {
            bw.append(data.getKey()).append(" ").append(String.valueOf(data.getValue()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static Map<String, Long> solve(List<String> list) {
        return list.stream().map(x -> x.split("\\.")[1]).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}