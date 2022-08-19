import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        Map<Integer, Set<Integer>> favor = new HashMap(n);
        int[] priority = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int p = Integer.parseInt(st.nextToken());
            priority[i] = p;
            favor.put(p, new HashSet<Integer>());
            for (int j = 0; j < 4; j++) { // 선호하는 사람 4명을 넣는다
                favor.get(p).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] result = solve(priority, favor, n);

        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                Set<Integer> favorSet = favor.get(result[i][j]);
                for (int k = 0; k < 4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if (cx < 0 || cx >= n || cy < 0 || cy >= n || !favorSet.contains(result[cx][cy])) continue;
                    count++;
                }
                s += calcPriority(count);
            }
        }

        System.out.println(s);
    }

    private static int calcPriority(int count) {
        switch (count) {
            case 1:
                return 1;
            case 2:
                return 10;
            case 3:
                return 100;
            case 4:
                return 1000;
            default: // case 0
                return 0;
        }
    }


    static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int priority;
        int empty;

        public Pos(int x, int y, int priority, int empty) {
            this.x = x;
            this.y = y;
            this.priority = priority;
            this.empty = empty;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.priority == o.priority) {
                if(this.empty == o.empty) {
                    if(this.x == o.x){
                        return this.y - o.y;
                    }else
                        return this.x - o.x;
                }else
                    return -(this.empty - o.empty);
            }else
                return -(this.priority - o.priority);


        }
    }

    private static int[][] solve(int[] lines, Map<Integer, Set<Integer>> favor, final int n) {
        int[][] result = new int[n][n];
        result[1][1] = lines[0]; // 시작점을 먼저 표기한다

        PriorityQueue<Pos> pq;
        // 맵이 작아서 브루트포스로 해도 문제 없음
        for (int nxt = 1; nxt < n * n; nxt++) {
            int current = lines[nxt];
            pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (result[i][j] == 0) { //비어있는 자리면 검증 시작
                        int priority = 0;
                        int empty = 0;
                        Set<Integer> favorSet = favor.get(current);
                        for (int k = 0; k < 4; k++) {
                            int cx = i + dx[k];
                            int cy = j + dy[k];
                            if (cx < 0 || cx >= n || cy < 0 || cy >= n) continue;
                            if(favorSet.contains(result[cx][cy])) priority++;
                            else if (result[cx][cy] == 0) empty++;
                        }
                        pq.add(new Pos(i, j, priority, empty));
                    }
                }
            }
            // 가장 최선의 위치를 빼낸 후 맵에 기입한다.
            Pos pos = pq.poll();
            result[pos.x][pos.y] = current;
        }
        return result;
    }
}