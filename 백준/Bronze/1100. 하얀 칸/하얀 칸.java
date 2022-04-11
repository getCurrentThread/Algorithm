import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for(int i = 0; i < 8; i++){
            String line = in.readLine();
            for(int j = 0; j < 8; j++){
                if(line.charAt(j) == 'F' && (i + j) % 2 == 0){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}