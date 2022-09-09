class Solution {
    public int[] solution(String s) {
        int rmCnt = 0;
        int binCnt = 0;
        while (true) {
            rmCnt += s.length() - (s = s.replace("0", "")).length();
            s = Integer.toBinaryString(s.length());
            ++binCnt;
            if (s.equals("1")) break;
        }
        return new int[]{binCnt, rmCnt};
    }

}