import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 <= N, T, R <= 200
        // 50 <= m <= M <= 200
        int N = Integer.parseInt(st.nextToken()); // 운동 시간(분)
        int m = Integer.parseInt(st.nextToken()); // 초기 맥박(최소)
        int M = Integer.parseInt(st.nextToken()); // 최대 맥박(최대)
        int T = Integer.parseInt(st.nextToken()); // 분당 맥박 증가율(운동)
        int R = Integer.parseInt(st.nextToken()); // 분당 맥박 감소율(휴식)

        System.out.println(solution(N, T, R, m, M));
    }

    private static int solution(int N, int T, int R, int m, int M) {
        int pulse = m;
        int time = 0;

        // 1분도 운동을 못하는 케이스
        if (m + T > M) return -1;


        while (true) {
            time++;
            if (pulse + T > M) {
                pulse = Math.max(pulse - R, m);
            } else {
                pulse += T;
                if (--N == 0) break;
            }
        }

        return time;
    }
}