import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text = in.readLine().trim();

        int []result = new int['z'-'a'+1];
        for(char ch : text.toCharArray()){
            result[ch-'a']++;
        }
        for(int i : result){
            System.out.print(i + " ");;
        }
    }
}