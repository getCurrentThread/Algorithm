import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int mx = Integer.parseInt(in.readLine());
        int mIdx = 1;
        for(int i  = 2; i <= 9; i++){
            int n = Integer.parseInt(in.readLine());
            if(mx < n){
                mx = n;
                mIdx = i;
            }
        }
        System.out.println(mx);
        System.out.println(mIdx);
    }
}