import java.io.*;
import java.util.*;

/*
input:
7 5
.......
.o...*.
.......
.*...*.
.......
15 13
.......x.......
...o...x....*..
.......x.......
.......x.......
.......x.......
...............
xxxxx.....xxxxx
...............
.......x.......
.......x.......
.......x.......
..*....x....*..
.......x.......
10 10
..........
..o.......
..........
..........
..........
.....xxxxx
.....x....
.....x.*..
.....x....
.....x....
0 0

output:
8
49
-1
*/
public class Main {
    static int N;
    static int M;
    static final int MAX = 987654321;

    static int[][] dp = new int[1 << 11][11];
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    static int[][] mapping = new int[20][20];
    static int[][] dist = new int[11][11];


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;

            char[][] board = new char[N][];
            for(int i = 0; i < N; i++) {
                board[i] = in.readLine().toCharArray();
            }
            int ans = solution(N, M, board);
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }

    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    private static int solution(final int N, final int M, char[][] board) {
        int dirty = 0;
        List<Pos> dirtys = new ArrayList<>();

        // 시작점 찾기
        start_point_search:
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 'o') {
                    board[i][j] = '.';
                    dirtys.add(new Pos(i, j));
                    break start_point_search;
                }
            }
        }

        //mapping배열 초기화
        for(int i = 0; i < N; i++) {
            Arrays.fill(mapping[i], 0);
        }

        // 더러운 장소 카운트
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == '*') {
                    dirty++;
                    mapping[i][j] = dirty;
                    dirtys.add(new Pos(i, j));
                }
            }
        }

        if(dirty == 0) return 0;

        // dist배열 초기화
        for(int i = 0; i <= dirty; i++) {
            Arrays.fill(dist[i], MAX);
        }

        for(int i = 0; i <= dirty; i++){
            dist[i][i] = 0;
        }

        //map 순회로 갈 수 있는 인접행렬 dp 값 채우기
        Queue<Pos> queue = new ArrayDeque<>();
        for(int i = 0; i < dirtys.size(); i++){
            boolean[][] visited = new boolean[N][M];
            queue.add(dirtys.get(i));
            int depth = 1;
            while(!queue.isEmpty()) {
                int qSize = queue.size();
                int cx, cy;
                while (qSize-- > 0) {
                    Pos cur = queue.poll();
                    cx = cur.x;
                    cy = cur.y;
                    visited[cx][cy] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || board[nx][ny] == 'x') continue;
                        visited[nx][ny] = true;
                        if (board[nx][ny] == '*') {
                            int idx = mapping[nx][ny];
                            dist[i][idx] = depth;
                        }
                        queue.add(new Pos(nx, ny));
                    }
                }
                depth++;
            }
        }
        System.gc();

        int nd = 1 << (dirty+1);
        for(int i = 0; i < nd; i++){
            Arrays.fill(dp[i], MAX);
        }
        int ans = TSP(dirty + 1, dist, dp,  1 << 0, 0);
        return ans == MAX ? -1 : ans;
    }

    private static int TSP(final int N, int[][] dist, int[][] dp, int mask, int cur) {
        if(dp[mask][cur] != MAX) return dp[mask][cur];
        if(mask == (1 << N) - 1) return 0;

        int min = MAX;
        for(int i = 0; i < N; i++) {
            if((mask & (1 << i)) == 0) {
                min = Math.min(min, dist[cur][i] + TSP(N, dist, dp, mask | (1 << i), i));
            }
        }

        return dp[mask][cur] = min;
    }
}