import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j15684 {
    static int N, M, H;
    static int map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (b - 1 >= 0)
                map[a][b - 1] = -1;
            map[a][b] = 1;
            if (b + 1 <= N)
                map[a][b + 1] = -1;
        }
        boolean stopFlag = false;
        int cnt = 0;
        if (!check()) {

            // 사다리 1개만 놓을 때에 가능한 케이스
            cnt = 1;
            for (int i = 1; i <= H; i++) {
                for (int j = 1; j < N; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        if (check()) {
                            stopFlag = true;
                            break;
                        }
                        map[i][j] = 0;
                    }
                }
                if (stopFlag)
                    break;
            }

            // 사다리 2개만 놓을 대에 가능한 케이스
            if (!stopFlag) {
                cnt = 2;
                for (int i = 1; i <= H; i++) {
                    for (int j = 1; j < N; j++) {
                        if (map[i][j] == 0) {
                            map[i][j] = 1;
                            int n = j + 2;
                            for (int m = i; m <= H; m++) {
                                for (; n < N; n++) {
                                    if (map[m][n] == 0) {
                                        map[m][n] = 1;
                                        if (check()) {
                                            stopFlag = true;
                                            break;
                                        }
                                        map[m][n] = 0;
                                    }
                                }
                                n = 1;
                                if (stopFlag)
                                    break;
                            }
                            if (stopFlag)
                                break;
                            map[i][j] = 0;
                        }
                    }
                    if (stopFlag)
                        break;
                }

            }

            // 사다리 3개만 놓을 대에 가능한 케이스
            if (!stopFlag) {
                cnt = 3;
                for (int i = 1; i <= H; i++) {
                    for (int j = 1; j < N; j++) {
                        if (map[i][j] == 0) {
                            map[i][j] = 1;
                            int n = j + 2;
                            for (int m = i; m <= H; m++) {
                                for (; n < N; n++) {
                                    if (map[m][n] == 0) {
                                        map[m][n] = 1;
                                        int w = n + 2;
                                        for (int q = m; q <= H; q++) {
                                            for (; w < N; w++) {
                                                if (map[q][w] == 0) {
                                                    map[q][w] = 1;
                                                    if (check()) {
                                                        stopFlag = true;
                                                        break;
                                                    }
                                                    map[q][w] = 0;
                                                }
                                            }
                                            w = 1;
                                            if (stopFlag)
                                                break;
                                        }
                                        map[m][n] = 0;
                                    }
                                }
                                n = 1;
                                if (stopFlag)
                                    break;
                            }
                            if (stopFlag)
                                break;
                            map[i][j] = 0;
                        }
                    }
                    if (stopFlag)
                        break;
                }

            }

            if (!stopFlag) {
                cnt = 4;
            }
        }

        if (cnt >= 4)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }

    private static boolean check() { // 원래 값으로 돌아오는지 체크
        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = i;

        int temp;
        for (int i = 1; i <= H; i++) { // i번째 줄에 대해
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 1) { // 사다리가 있다면, 스왑 진행
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 조건 검사
        for (int i = 1; i <= N; i++) {
            if (arr[i] != i)
                return false;
        }
        return true;
    }
}
