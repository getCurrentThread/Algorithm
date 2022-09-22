class Solution {
    public int[] solution(int n, int s) {
        if (s / n <= 0) // 자연수로 만들 수 있는 집합이 존재치 않으므로
            return new int[]{-1};

        int[] answer = new int[n];
        for (int i = 0; i < n; i++)
            answer[i] = s / n;

        for (int i = n - (s % n); i < n; i++)
            ++answer[i];
        return answer;
    }
}