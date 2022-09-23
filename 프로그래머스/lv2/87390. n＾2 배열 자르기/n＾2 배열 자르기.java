class Solution {
    public int[] solution(int n, long left, long right) {
        int idx = 0;
        int[] answer = new int[(int) (right - left) + 1];
        for (long l = left; l <= right; l++) {
            final long row = (l / n) + 1;
            final long col = (l % n) + 1;
            answer[idx++] = (int) (row < col ? col : row);
        }
        return answer;
    }
}