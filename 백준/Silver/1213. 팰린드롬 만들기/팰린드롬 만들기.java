import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 순열이라면 50!(=50P50) 이므로 사실상 시간초과를 피할 수 없음
        // 위와 동일한 이유로 worst 케이스를 피할 수 없으므로 BFS, DFS도 불가
        // 그리디

        String word = br.readLine();
        int[] cnt = new int['Z' - 'A' + 1];
        for (char ch : word.toCharArray()) {
            cnt[ch - 'A']++;
        }

        // 문자열의 길이와 알파벳 개수를 고려하여 펠린드롬을 만들 수 없는 경우를 확인
        // 펠린드롬 문자열이 성립하는 조건
        // 1. 문자열이 홀수인 경우에는 알파벳 개수가 단 하나만 홀수여야만 함
        // 2. 문자열이 짝수인 경우에는 알파벳 개수가 모두 짝수여야만 함
        if ((word.length() % 2 == 1 && Arrays.stream(cnt).filter(i -> i % 2 == 1).count() != 1)
                || (word.length() % 2 == 0 && Arrays.stream(cnt).filter(i -> i % 2 == 1).count() != 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 나머지는 팰린드롬 문자열을 만들 수 있음. (사전순이므로 A~Z로 순차적으로 반복하면서 만들면 됨)
        StringBuilder sb = new StringBuilder();

        // 팰린드롬 문자열의 앞을 오름차순으로 만들기
        for (int i = 0; i < cnt.length; i++) {
            for (int j = cnt[i] / 2; j > 0; j--) {
                sb.append((char) ('A' + i));
            }
        }

        // 하나의 홀수인 문자 있다면 이 시점에 붙이기 (상위 조건에 의해서 추가 체크가 불필요)
//        if (Arrays.stream(cnt).filter(i -> i % 2 == 1).count() == 1) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] % 2 == 1) {
                sb.append((char) ('A' + i));
                cnt[i]--;
                break;
            }
        }
//        }

        // 나머지 문자열을 내림차순으로 이어 붙이기
        for (int i = cnt.length - 1; i >= 0; i--) {
            for (int j = cnt[i] / 2; j > 0; j--) {
                sb.append((char) ('A' + i));
            }
        }

        System.out.println(sb.toString());
    }
}