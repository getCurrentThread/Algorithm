class Solution {
    public int solution(final int n) {
        int count = 0;
        int sum = 0;
        int l = 0, r = 0;
        while (l < n) {
            if (sum == n) {
                ++count;
            }
            if (sum >= n) {
                sum -= ++l;
            } else { // sum > n
                sum += ++r;
            }
        }
        return count;
    }

//    public static void main(String[] args) {
//        new Solution().solution(15);
//        new Solution().solution(1);
//    }
}