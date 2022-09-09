class Solution {
    public String solution(String s) {
        return convertJadenCase(s);
    }

    public String convertJadenCase(final String s) {
        char[] arr = s.toLowerCase().toCharArray();

        // replace first character "a~z" -> 'A~Z'
        if (arr.length > 0 && arr[0] >= 'a' && arr[0] <= 'z')
            arr[0] = (char) (arr[0] - 'a' + 'A');

        for (int i = arr.length - 1; i > 0; --i) {
            if (arr[i - 1] == ' ' && arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] += 'A' - 'a';
            }
        }
        return String.valueOf(arr);
    }
}