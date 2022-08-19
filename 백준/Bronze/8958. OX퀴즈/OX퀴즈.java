import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        while(N-- > 0){
            int score = 0;
            int point = 0;
            for(char ch : in.readLine().toCharArray()){
                if(ch == 'O'){
                    score += ++point;
                }else{ // X
                    point = 0;
                }
            }
            out.append(score).append("\n");
        }
        System.out.print(out);
    }
}
