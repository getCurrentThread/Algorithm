import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] count = new int[n];

        int[][] map = new int[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (map[i][k] == map[j][k]) {
                        count[i]++;
                        count[j]++;
                        break;
                    }
                }
            }
        }

        int mx = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > mx) {
                mx = count[i];
                idx = i;
            }
        }

        System.out.println(idx + 1);
    }
}