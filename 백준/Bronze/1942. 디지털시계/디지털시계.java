import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 3;
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = timestamp(st.nextToken());
            int end = timestamp(st.nextToken());
            int curTime = start;
            int count = 0;
            if (end - start < 0)
                end += 24 * 60 * 60;
            while (curTime <= end) {
                if (datetime(curTime) % 3 == 0) {
                    ++count;
                }
                ++curTime;
            }
            System.out.println(count);
        }
    }

    private static int timestamp(String str) {
        return Arrays.stream(str.split(":"))
                .mapToInt(Integer::valueOf)
                .reduce(0, (a, b) -> a * 60 + b);
    }

    private static int datetime(int timestamp) {
        int hours = timestamp / 3600;
        int mins = timestamp % 3600 / 60;
        int seconds = timestamp % 60;
        return hours * 10000 + mins * 100 + seconds;
    }
}
