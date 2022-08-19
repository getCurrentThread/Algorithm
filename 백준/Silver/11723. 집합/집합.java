import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        int m = Integer.parseInt(in.readLine());
        while(m-- > 0) {
            String[] line = in.readLine().split(" ");
            switch (line[0]) {
                case "add":
                    set.add(Integer.parseInt(line[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(line[1]));
                    break;
                case "check":
                    out.append(set.contains(Integer.parseInt(line[1])) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if(set.contains(Integer.parseInt(line[1]))) {
                        set.remove(Integer.parseInt(line[1]));
                    }else{
                        set.add(Integer.parseInt(line[1]));
                    }
                    break;
                case "all":
                    set.clear();
                    set.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(out);
    }
}