import java.util.HashMap;
import java.util.Map;

class Solution {
    final static char[][] types = new char[][]{{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < types.length; ++i) {
            for (int j = 0; j < types[i].length; ++j) {
                map.put(types[i][j], 0);
            }
        }

        for (int i = 0; i < survey.length; i++) {
            char[] ty = survey[i].toCharArray();
            int choice = choices[i] - 4;
            if (choice < 0) map.put(ty[0], map.get(ty[0]) - choice);
            else map.put(ty[1], map.get(ty[1]) + choice);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length; i++) {
            sb.append(
                    map.get(types[i][0]) >= map.get(types[i][1]) ? types[i][0] : types[i][1]
            );
        }
        return sb.toString();
    }
}