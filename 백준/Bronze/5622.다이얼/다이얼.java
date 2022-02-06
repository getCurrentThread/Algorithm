import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        int time = 0;
        for (char ch : in.readLine().toCharArray()) {
            time += dial(ch);
        }
        System.out.println(time);
    }
    static int[] dials = new int[]{3,3,3,3,3,4,3,4};
    static{
        for(int i = 1; i < dials.length; i++){
            dials[i] = dials[i] + dials[i-1];
        }
    }
    static int dial(final char ch) {
        int index = ch - 'A';
        for(int i = 0; i < dials.length; i++){
            if(index < dials[i])
                return i+3;
        }
        return -1;
    }



}