import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> arr = new ArrayList<>();
        for (String s1 : s.substring(0, s.length() - 1).split("(\\}\\,\\{)")) {
            String[] tmp = s1.replace("{", "").replace("}", "").split(",");
            List<Integer> list = new ArrayList<>();
            for (String s2 : tmp) {
                list.add(Integer.valueOf(s2));
            }
            arr.add(list);
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        //길이순으로 오름차순
        arr.sort((a, b) -> Integer.compare(a.size(), b.size()));
        for (List<Integer> list : arr) {
            for (int i : list) {
                if (set.contains(i)) {
                    continue;
                }
                set.add(i);
                result.add(i);
                break;
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}