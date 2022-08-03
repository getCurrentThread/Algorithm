import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[] garo = new boolean[n];
        boolean[] sero = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'X') {
                    garo[i] = true;
                    sero[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!garo[i]) {
                cnt++;
            }
        }

        int cnt2 = 0;
        for (int i = 0; i < m; i++) {
            if (!sero[i]) {
                cnt2++;
            }
        }

        System.out.println(Math.max(cnt, cnt2));

    }
}