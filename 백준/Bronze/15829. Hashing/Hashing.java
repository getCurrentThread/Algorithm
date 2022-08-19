import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String text = br.readLine();

        int mod = 123456789;
        // 몇 개 입력 받을 껀지 체크

        // 문자열 입력 받음
        long result = 0;
        long j = 1;

        for (int i = 0; i < n; i++) {
            // a 97 z 122
            result += (text.charAt(i) - 96) * j;
            result %= mod;
            j = (j * 31) % mod;

        }

        System.out.println(result % mod);

    }


}