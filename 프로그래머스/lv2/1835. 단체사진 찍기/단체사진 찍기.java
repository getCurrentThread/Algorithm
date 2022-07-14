import java.util.ArrayList;
import java.util.List;

class Solution {
    static class Constraint {
        char a, b;
        char cmp;
        int dist;

        Constraint(char a, char b, char cmp, int dist) {
            this.a = a;
            this.b = b;
            this.cmp = cmp;
            this.dist = dist;
        }
    }

    public int solution(int n, String[] data) {
        int answer = 0;
        List<Constraint> constraints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char a = data[i].charAt(0);
            char b = data[i].charAt(2);
            char cmp = data[i].charAt(3);
            int dist = data[i].charAt(4) - '0';
            constraints.add(new Constraint(a, b, cmp, dist));
        }

        char[] members = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        boolean[] visited = new boolean[members.length];
        char[] current = new char[members.length];
        count = 0;
        dfs(members, visited, constraints, current, 0);

        return count;
    }

    static int count = 0;

    private void dfs(char[] members, boolean[] visited, List<Constraint> constraints, char[] current, final int depth) {
        if (depth == members.length) {
            count++;
            return;
        }
        for (int i = 0; i < members.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current[depth] = members[i];
                if (isValid(constraints, current, depth)) {
                    dfs(members, visited, constraints, current, depth + 1);
                }
                visited[i] = false;
            }
        }
    }

    // check constraints...
    private boolean isValid(List<Constraint> constraints, char[] current, int depth) {
        for (Constraint constraint : constraints) {
            int a = indexOf(current, constraint.a);
            int b = indexOf(current, constraint.b);
            if (a < 0 || b < 0 || a > depth || b > depth) continue;

            int diff = Math.abs(a - b) - 1;
            int dist = constraint.dist;
            char cmp = constraint.cmp;
            switch (cmp) {
                case '>':
                    if (diff <= dist) return false;
                    break;
                case '<':
                    if (diff >= dist) return false;
                    break;
                case '=':
                    if (diff != dist) return false;
                    break;
            }
        }
        return true;
    }

    private int indexOf(char[] data, char target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

//    @Test
//    public void test() {
//        assert 3648 == new Solution().solution(2, new String[]{"N~F=0", "R~T>2"});
//        assert 0 == new Solution().solution(2, new String[]{"M~C<2", "C~M>1"});
//    }
}