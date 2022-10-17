import java.util.Arrays;

class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int top = denum1 * num2 + denum2 * num1;
        int bottom = num1 * num2;
        int val = gcd(top, bottom);
        top /= val;
        bottom /= val;
        return new int[]{top, bottom};
    }

    static public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}