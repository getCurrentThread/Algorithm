import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for(int i = 1; i < 10; i++) {
            System.out.println(N + " * " + i + " = " + N * i);
        }
    }
}