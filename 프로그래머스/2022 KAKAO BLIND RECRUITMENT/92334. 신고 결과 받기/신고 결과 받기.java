import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i], new HashSet<String>());
        }

        for(int i = 0; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String user_id = st.nextToken();
            String black_id = st.nextToken();

            // 유저가 벤 당한 유저에게 누가 신고했는지 ID를 기록합니다.
            map.get(black_id).add(user_id);
        }

        Map<String, Integer> user_mapping = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            user_mapping.put(id_list[i], i);
        }

        for(int i = 0; i < id_list.length; i++){
            String user_id = id_list[i];
            Set<String> set = map.get(user_id);
            if(set.size() >= k){
                for(String user : set){
                    answer[user_mapping.get(user)]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        new Solution().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
    }
}