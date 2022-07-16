import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String line = br.readLine();
            if(line.length() >= 1000){
                throw new RuntimeException("최대 문자 길이 1000인 경우가 들어왔습니다.");
            }
            String[] arr = line.split(" ");
            for(String str : arr){
                System.out.print(new StringBuilder(str).reverse().toString() + " ");
            }
            System.out.println();
        }
    }
}