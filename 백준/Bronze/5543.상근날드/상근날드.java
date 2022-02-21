import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int burger = Math.min(Math.min(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine())), Integer.parseInt(in.readLine()));
        int juice = Math.min(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));

        System.out.println(burger + juice - 50);
    }
}
