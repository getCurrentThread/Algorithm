import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class j1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<Integer> ();
        int n = sc.nextInt();
        int k = sc.nextInt();

        q.offer(n);
        int time = 0;
        boolean visited [] = new boolean[100001];
        outer: while(!q.isEmpty()) {
            int qSiz = q.size();
            for(int i = 0; i < qSiz; i++) {
                int x = q.poll();
                if(x == k) break outer;
                if(x-1 >= 0 && !visited[x-1]) {q.offer(x-1);visited[x-1] = true;}
                if(x+1 <= 100000 && !visited[x+1]) {q.offer(x+1);visited[x+1] = true;}
                if(x*2 <= 100000 && !visited[x*2]) {q.offer(x*2); visited[x*2] = true;}
            }
            time++;
        }
        System.out.println(time);
    }
}
