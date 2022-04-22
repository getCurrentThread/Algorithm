import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] params) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        
        int n = Integer.parseInt(in.readLine());
        
        int[] cArr = new int['z' - 'a' + 1];
        while(n-- > 0){
            cArr[in.readLine().charAt(0) - 'a']++;
        }
        
        boolean isFlag = false;
        for(int i = 0; i < 'z' - 'a' + 1; i++){
            if(cArr[i] >= 5){
                out.append((char)(i + 'a'));
                isFlag = true;
            }
        }
        
        if(isFlag){
            System.out.println(out);
        }else{
            System.out.println("PREDAJA");
        }
    }
}