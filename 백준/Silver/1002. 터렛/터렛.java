import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int Tcase = Integer.parseInt(in.readLine());
        for(int t = 1; t <= Tcase; t++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(solution(x1, y1, r1, x2, y2, r2));
        }
    }

    // -10000 <= x1, y1, x2, y2 <= 10000
    // r1, r2 is neutral number.
    private static int solution(final int x1, final int y1, final int r1, final int x2, final int y2, final int r2) {
        if(r1 <= 0 || r2 <= 0) {
            throw new RuntimeException("자연수만 입력하세요");
        }
        if(x1 == x2 && y1 == y2 && r1 == r2) return -1; // 모두 겹치는 조건이므로 무수히 많음

        int distance = square(x1 - x2) + square(y1 - y2);
        int rMin = square(r1 - r2);
        int rMax = square(r1 + r2);

        if(rMin < distance && distance < rMax) return 2; // 두 점에서 만나는 경우
        else if(rMin == distance || distance == rMax) return 1; // 한 점에서 만나는 경우
        else return 0; // 아무것도 만나지 않는 경우
    }

    private static int square(int num){
        return num * num;
    }
}