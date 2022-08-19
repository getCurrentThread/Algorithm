import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String number;
        while(!(number  = in.readLine()).equals("0")) {
            if(isPalindrome(number)) {
                out.append("yes\n");
            }else{
                out.append("no\n");
            }
        }

        System.out.print(out);
    }

    public static boolean isPalindrome(String number) {
        int left = 0, right = number.length() - 1;
        while(left < right) {
            if(number.charAt(left) != number.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}