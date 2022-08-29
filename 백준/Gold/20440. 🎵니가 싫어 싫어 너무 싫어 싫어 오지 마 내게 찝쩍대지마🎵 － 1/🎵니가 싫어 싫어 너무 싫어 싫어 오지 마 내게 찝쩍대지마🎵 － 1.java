import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Pair implements Comparable<Pair> {
        int l, r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.l, o.l) == 0 ? Integer.compare(this.r, o.r) : Integer.compare(this.l, o.l);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Pair> input = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>(); // 시간 : 추감산된 모기 마릿수
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            input.add(new Pair(e, x));
        }

        // 순차적인 배열로는 사용하기 어려우므로 map을 활용하여 압축
        for (Pair p : input) {
            m.put(p.l, m.getOrDefault(p.l, 0) + 1);
            m.put(p.r, m.getOrDefault(p.r, 0) - 1);
        }

        // 합산이 가장 높아지는 지점 확인
        int sum = 0;
        boolean flag = false;
        int mCnt = 0, mStart = 0, mEnd = 0;
        for (int time : m.keySet().stream().sorted().collect(Collectors.toList())) {
            int count = m.get(time);
            if (sum == mCnt && count < 0 && flag) {
                mEnd = time; // 종료 시간 갱신
                flag = false;
            }
            sum += count; // 합 누적
            if (sum > mCnt) {
                mCnt = sum;
                mStart = time; // 시작 시간 갱신
                flag = true;
            }
        }

        StringBuilder out = new StringBuilder();
        out.append(mCnt).append('\n');
        out.append(mStart).append(' ').append(mEnd);
        System.out.println(out);
    }
}