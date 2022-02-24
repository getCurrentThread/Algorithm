// public class 프로그래머스_없는숫자더하기 {
    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            boolean[] chck = new boolean[10];
            for (int i = 0; i < numbers.length; i++)
                chck[numbers[i]] = true;

            for (int i = 1; i < 10; i++) {
                if (!chck[i])
                    answer += i;
            }
            return answer;
        }
    }
// }