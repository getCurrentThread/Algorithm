import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        for(String word : new String[]{"c=","c-","dz=","d-","lj","nj","s=","z="}) {
            line = line.replace(word, "a");
        }
        System.out.println(line.length());
    }
}