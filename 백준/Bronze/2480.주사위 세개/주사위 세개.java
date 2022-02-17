import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if(A == B && B == C){
            System.out.println(10000 + A * 1000);
        }else if(A == B || B == C || A == C){
            System.out.println(1000 + (A + B + C - (A ^ B ^ C)) / 2 * 100);
        }else{
            System.out.println(Math.max(Math.max(A, B),C) * 100);
        }
    }
}
