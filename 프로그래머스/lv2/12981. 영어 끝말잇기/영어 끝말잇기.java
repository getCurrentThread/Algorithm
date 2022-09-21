import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int idx = 0;
        int loop = 0;

        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i])
                    || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                idx = (i % n) + 1;
                loop = (i / n) + 1;
                break;
            } else {
                set.add(words[i]);
            }
        }
        return new int[]{idx, loop};
    }
}