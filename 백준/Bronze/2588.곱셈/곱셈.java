import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(in.readLine());
        int B = Integer.parseInt(in.readLine());
        for(int i = 1; i <= 100; i*=10){
            int b = B / i % 10;
            System.out.println(A * b);
        }
        System.out.println(A*B);
    }
}