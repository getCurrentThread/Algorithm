class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if (num % 2 == 1) {
            answer[0] = total / num - (num / 2);
            for (int i = 1; i < num; i++) {
                answer[i] = answer[i - 1] + 1;
            }
        } else {
            answer[0] = total / num - (num / 2) + 1;
            for (int i = 1; i < num; i++) {
                answer[i] = answer[i - 1] + 1;
            }
        }
        return answer;
    }
}