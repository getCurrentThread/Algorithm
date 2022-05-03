import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Tcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= Tcase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            int count = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if ((isInCircle(x1, y1, cx, cy, r) && !isInCircle(x2, y2, cx, cy, r))
                        || (isInCircle(x2, y2, cx, cy, r) && !isInCircle(x1, y1, cx, cy, r))) {
                    count++;
                }
            }

            bw.append(count + "\n");

        }

        bw.flush();
        bw.close();
    }

    static boolean isInCircle(int x, int y, int cx, int cy, int r) {
        return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= r * r;
    }
}