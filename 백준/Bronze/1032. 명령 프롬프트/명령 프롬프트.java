import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        char[][] sArr = new char[n][];
        for (int i = 0; i < n; i++) {
            sArr[i] = in.readLine().toCharArray();
        }

        for(int i = 0; i < sArr[0].length; i++) {
            int j = 1;
            for (; j < n; j++) {
                if(sArr[j][i] != sArr[0][i]) {
                    out.append('?');
                    break;
                }
            }
            if(j == n){
                out.append(sArr[0][i]);
            }
        }

        System.out.println(out);
    }
}
