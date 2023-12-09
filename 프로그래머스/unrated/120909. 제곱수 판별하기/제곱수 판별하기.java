import java.lang.Math;

class Solution {
    public int solution(int n) {
        int x = (int) (Math.sqrt(n) + 0.5);
        return x * x == n ? 1 : 2;
    }
}