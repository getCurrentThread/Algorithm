import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>(10);
        for(int i = 0 ; i < 10; i ++){
            set.add(Integer.parseInt(in.readLine()) % 42);
        }
        System.out.println(set.size());
    }
}
