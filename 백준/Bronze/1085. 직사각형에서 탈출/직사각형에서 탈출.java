import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        System.out.println(solution(x, y, w, h));
    }

    private static int solution(int x, int y, int w, int h) {
        int dx = Math.min(x, Math.abs(x - w));
        int dy = Math.min(y, Math.abs(y - h));
        return Math.min(dx, dy);
    }

}