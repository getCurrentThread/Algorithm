import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class j17140 {
    static int r, c, k;
    static int[][] map;
    static int mRow, mCol;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[102][102];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 현재 길이 3x3
        mRow = 3;
        mCol = 3;

        int sec = simulate();

        if (sec > 100)
            System.out.println(-1);
        else
            System.out.println(sec);
    }

    private static int simulate() {
        int t = 0;

        int val;
        for (; t <= 100; t++) {
            if (map[r][c] == k && mRow >= r && mCol >= c)
                break;
            int nx = 0;
            if (mRow >= mCol) { // R 연산
                for (int i = 1; i <= mRow; i++) {
                    Map<Integer, Integer> freq = new HashMap<>();
                    for (int j = 1; j <= mCol; j++) {
                        val = map[i][j];
                        freq.put(val, freq.containsKey(val) ? freq.get(val) + 1 : 1);
                    }
                    List<Pair> list = new ArrayList<>();
                    for (Entry<Integer, Integer> elem : freq.entrySet()) {
                        if (elem.getKey() == 0)
                            continue;
                        list.add(new Pair(elem.getKey(), elem.getValue()));
                    }
                    Collections.sort(list, (a, b) -> {
                        if (a.count == b.count)
                            return a.num - b.num;
                        return a.count - b.count;
                    });
                    nx = Math.max(nx, list.size() * 2 <= 100 ? list.size() * 2 : 100);
                    for (int j = 0; j < list.size() && j < 50; j++) {
                        Pair pair = list.get(j);
                        map[i][j * 2 + 1] = pair.num;
                        map[i][j * 2 + 2] = pair.count;
                    }
                    for (int j = (list.size() * 2 <= 100 ? list.size() * 2 : 100) + 1; j <= 100; j++) {
                        map[i][j] = 0;
                    }
                }
                mCol = nx;

            } else { // C 연산
                for (int j = 1; j <= mCol; j++) {
                    Map<Integer, Integer> freq = new HashMap<>();
                    for (int i = 1; i <= mRow; i++) {
                        val = map[i][j];
                        freq.put(val, freq.containsKey(val) ? freq.get(val) + 1 : 1);
                    }
                    List<Pair> list = new ArrayList<>();
                    for (Entry<Integer, Integer> elem : freq.entrySet()) {
                        if (elem.getKey() == 0)
                            continue;
                        list.add(new Pair(elem.getKey(), elem.getValue()));
                    }
                    Collections.sort(list, (a, b) -> {
                        if (a.count == b.count)
                            return a.num - b.num;
                        return a.count - b.count;
                    });
                    nx = Math.max(nx, list.size() * 2 <= 100 ? list.size() * 2 : 100);
                    for (int i = 0; i < list.size() && i < 50; i++) {
                        Pair pair = list.get(i);
                        map[i * 2 + 1][j] = pair.num;
                        map[i * 2 + 2][j] = pair.count;
                    }
                    for (int i = (list.size() * 2 <= 100 ? list.size() * 2 : 100) + 1; i <= 100; i++) {
                        map[i][j] = 0;
                    }
                }
                mRow = nx;
            }
        }
        return t;
    }

    static class Pair {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

}
