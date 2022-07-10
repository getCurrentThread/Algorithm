import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        // 맵 업데이트
        for (int i = 0; i < record.length; i++) {
            String[] params = record[i].split(" ");
            switch (params[0]) {
                case "Enter":
                case "Change":
                    map.put(params[1], params[2]);
            }
        }

        // 출력
        for(int i = 0; i < record.length; i++){
            String[] params = record[i].split(" ");
            switch (params[0]) {
                case "Enter":
                    result.add(String.format("%s님이 들어왔습니다.", map.get(params[1])));
                    break;
                case "Leave":
                    result.add(String.format("%s님이 나갔습니다.", map.get(params[1])));
                    break;
            }
        }
        return result.stream().toArray(String[]::new);
    }
}