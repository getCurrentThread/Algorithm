import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(" "))
                .map(x -> convertJadenCase(x)) // make lowercase...
                .collect(Collectors.joining(" "));
    }

    public String convertJadenCase(final String s) {
        char[] arr = s.toLowerCase(Locale.ROOT).toCharArray();
        if (arr.length > 0 && arr[0] >= 'a' && arr[0] <= 'z')
            arr[0] = (char) (arr[0] - 'a' + 'A');
        return String.valueOf(arr);
    }
    
}