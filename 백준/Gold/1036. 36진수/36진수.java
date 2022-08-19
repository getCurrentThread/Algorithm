import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int n = Integer.parseInt(in.readLine());

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.readLine();
        }

        int k = Integer.parseInt(in.readLine());

        // Solution
        while (k-- > 0) {
            go(n, input);
        }
        // Output
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            result = result.add(new BigInteger(input[i], 36));
        }
        System.out.println(result.toString(36).toUpperCase());
    }

    final static char[] base36 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static String[] go(int n, String[] input) {
        char target = (char) base36[0];
        BigInteger mx = BigInteger.ZERO;

        for (char ch : base36) {
            BigInteger cur = BigInteger.ZERO;
            for (String s : input) {
                cur = cur.add(new BigInteger(s.replace(ch, 'Z'), 36));
            }
            if (cur.compareTo(mx) > 0) {
                mx = cur;
                target = ch;
            }
        }
//        // 추가 리소스를 사용하게 되므로 시간 효율을 위해 삭제
//        char finalTarget = target;
//        return Arrays.stream(input).map(s -> s.replace(finalTarget, 'Z')).toArray(String[]::new);

        for (int i = 0; i < n; i++) {
            input[i] = input[i].replace(target, 'Z');
        }
        return input;
    }
}

