class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}