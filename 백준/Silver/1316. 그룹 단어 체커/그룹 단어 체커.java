import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int count = 0;
        for(int i = 0; i < N; i++){
            if(isGroupWord(in.readLine())){
                count++;
            };
        }
        System.out.println(count);
    }

    private static boolean isGroupWord(String line) {
        boolean check[] = new boolean['z' - 'a' + 1];
        char[] chars = line.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(check[chars[i] - 'a']){
                return false;
            }else{
                for(int j = i + 1; j < chars.length; j++){
                    if(chars[i] == chars[j]){
                        i = j;
                        continue;
                    }
                    break;
                }
                check[chars[i] - 'a'] = true;
            }
        }
        return true;
    }
}