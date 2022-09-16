class Solution {
    public int solution(int n) {
        final int count = Integer.bitCount(n);
        while (true) {
            if (count == Integer.bitCount(++n))
                return n;
        }
    }
}