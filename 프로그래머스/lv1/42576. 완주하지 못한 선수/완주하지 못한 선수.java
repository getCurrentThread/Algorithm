import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = null;
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        if (answer == null) {
            answer = participant[participant.length - 1];
        }

        return answer;
    }
}