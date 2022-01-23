import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][];

        for(int i = 0; i < N; i++){
            map[i] = in.readLine().trim().toCharArray();
        }

        int ans = simulate(N, M, map);
        System.out.println(ans);
    }

    static final int dx[] = {0, 0, -1, 1};
    static final int dy[] = {-1, 1, 0, 0};
    static class Node implements Comparable{
        int dir;
        int count;
        int x;
        int y;
        int step;
        Node(int dir, int count, int x, int y, int step){
            this.dir = dir;
            this.count = count;
            this.x = x;
            this.y = y;
            this.step = step;
        }


        @Override
        public int compareTo(Object o) {
            Node other = (Node) o;
                return (this.count == other.count) ?
                        this.step - other.step :
                        this.count - other.count;
        }
    }

    private static int simulate(final int N, final int M, final char[][] map) {
        int[][] chck = new int[N][M]; // 꺾은 횟수가 적은 카운트만 통과하는 체크용맵
            for (int i = 0; i < N; i++) {
                Arrays.fill(chck[i], Integer.MAX_VALUE);
            }

        int sx = -1, sy = -1;
        find_start_point:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if (map[i][j] == 'C') {
                    sx = i;
                    sy = j;
                    map[i][j] = '.';
                    break find_start_point;
                }
            }
        }



        // BFS 순회를 하되, 해당 노드가 꺾은 카운트가 같거나 작은 경우에만 통과하도록 함
        Queue<Node> q = new PriorityQueue<>();
        for(int i = 0; i < 4; i++ ){
            q.add(new Node(i, 0, sx, sy, 0));
        }
        chck[sx][sy] = 0;

        // 전맵 순회를 기준으로 로직 작성
        int cx, cy, count;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i = 0 ; i < 4; i++){
                cx = node.x + dx[i];
                cy = node.y + dy[i];
                count = node.count + (node.dir == i ? 0 : 1);
                if(cx < 0 || cx >= N || cy < 0 || cy >= M || map[cx][cy] == '*' || chck[cx][cy] < count)
                    continue;
                chck[cx][cy] = count;
                if(map[cx][cy] == 'C') continue;
                q.add(new Node(i, count, cx, cy, node.step+1));
            }
        }

        int nx = -1, ny = -1;
        find_end_point:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if (map[i][j] == 'C') {
                    nx = i;
                    ny = j;
                    break find_end_point;
                }
            }
        }

        return chck[nx][ny];
    }
}
