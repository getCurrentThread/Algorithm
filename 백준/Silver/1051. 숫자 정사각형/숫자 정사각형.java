import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = in.readLine().toCharArray();
        }

        int result = simulate(map, n, m);
        System.out.println(result);
    }

    private static int simulate(char[][] map, int n, int m) {
        int step = Math.min(n, m);
        while (step > 0) {
            for (int i = 0; i + step < n; i++) {
                for (int j = 0; j + step < m; j++) {
                    if (map[i][j] == map[i + step][j + step]
                            && map[i][j] == map[i + step][j]
                            && map[i][j] == map[i][j + step])
                        return (step + 1) * (step + 1);
                }
            }
            step--;
        }
        return 1;
    }
}