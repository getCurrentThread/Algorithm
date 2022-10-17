class Solution {
    final static String[] words = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling) {
            if (check(b)) {
                answer++;
            }
        }
        return answer;
    }

    static public boolean check(String b) {
        int tmp = 0, idx = 0;
        while (idx < b.length()) {
            for (String word : words) {
                if (b.indexOf(word, idx) == idx) {
                    tmp = idx + word.length();
                    if (b.indexOf(word, tmp) == tmp) { // 연속적으로 같은 단어가 놓인 경우
                        return false;
                    }
                }
            }
            if (tmp == idx) {
                return false;
            }
            idx = tmp;
        }
        // must true...
        return idx >= b.length();
    }

    // public static void main(String[] args) {
    //     System.out.println(new Solution().solution(new String[]{"aya", "yee", "u", "maa"}));
    //     System.out.println(new Solution().solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    // }
}