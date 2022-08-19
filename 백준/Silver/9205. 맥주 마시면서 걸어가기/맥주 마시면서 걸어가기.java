import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int Tcase = Integer.parseInt(in.readLine());

        for (int T = 1; T <= Tcase; T++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            List<Pos> conveniences = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine());
                conveniences.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(in.readLine());
            Pos end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (simulate(start, end, conveniences)) {
                out.append("happy\n");
            } else {
                out.append("sad\n");
            }
        }
        System.out.print(out);
    }

    private static int getDistance(final Pos a, final Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static boolean simulate(Pos start, Pos end, List<Pos> conveniences) {

        Queue<Pos> q = new ArrayDeque<>();
        boolean[] visited = new boolean[conveniences.size()];
        q.add(new Pos(start.x, start.y));

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (getDistance(cur, end) <= 1000) {
                return true;
            }
            for(int i = 0; i < conveniences.size(); i++) {
                if (!visited[i]) {
                    Pos convenience = conveniences.get(i);
                    if (getDistance(cur, convenience) <= 1000) {
                        visited[i] = true;
                        q.add(new Pos( convenience.x,  convenience.y));
                    }
                }
            }
        }
        return false;
    }

}