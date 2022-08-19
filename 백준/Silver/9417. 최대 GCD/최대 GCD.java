import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(in.readLine());

        int arr[] = new int[100];
        int a, b;
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int m = 0;
            while (st.hasMoreTokens()) {
                arr[m++] = Integer.parseInt(st.nextToken());
//                if(arr[m-1] < 0) throw new RuntimeException("조건에 해당하지 않습니다.");
            }

            int mx = 1;
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    mx = Math.max(mx, gcd(arr[i], arr[j]));
                }
            }
            out.append(mx).append('\n');
        }

        System.out.println(out);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

