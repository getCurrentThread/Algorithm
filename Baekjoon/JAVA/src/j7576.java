import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class j7576 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) q.offer(new int[] {i,j});
            }
        }
        int day = -1;

        int []dx = {0, 0, -1, 1};
        int []dy = {-1, 1, 0,0};
        while(!q.isEmpty()) {
            for(int s = q.size(); s > 0; s--) {
                int[] ele = q.poll();
                for(int i = 0 ; i < 4; i++) {
                    int cx = ele[0] + dx[i];
                    int cy = ele[1] + dy[i];
                    if(0<=cx && 0<= cy&& cx <n && cy <m && map[cx][cy] == 0) {
                        map[cx][cy] = 1;
                        q.offer(new int[] {cx, cy});
                    }
                }
            }
            day++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day);
    }
}
