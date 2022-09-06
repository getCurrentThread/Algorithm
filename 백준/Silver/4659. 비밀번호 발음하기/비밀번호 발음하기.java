import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = br.readLine()).equals("end")) {
            if (check(input)) {
                bw.write(String.format("<%s> is acceptable.", input));
            } else {
                bw.write(String.format("<%s> is not acceptable.", input));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static final char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    private static boolean isVowel(final char ch) {
        for (int i = 0; i < vowels.length; i++) {
            if (ch == vowels[i]) return true;
        }
        return false;
    }

    private static boolean isContainedVowel(final String input) {
        for (final char ch : input.toCharArray()) {
            if (isVowel(ch)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(final String input) {
        // contains 'a', 'e', 'i', 'o', 'u'
        if (!isContainedVowel(input)) return false;
        // not contains triple vowel, consonant.
        if (isContainedTripleVowelOrConsonant(input)) return false;
        // not includes double same letters. except "ee", "oo".
        if (isContainedDoubleSameLetters(input)) return false;

        return true;
    }

    private static boolean isContainedDoubleSameLetters(String input) {
        final char[] temp = input.replace("ee", "").replace("oo", "").toCharArray();
        for (int i = temp.length - 1; i >= 1; i--) {
            if (temp[i] == temp[i - 1]) return true;
        }
        return false;
    }

    private static boolean isContainedTripleVowelOrConsonant(final String input) {
        boolean nowVowel = true;
        int count = 0;
        for (final char ch : input.toCharArray()) {
            if (isVowel(ch) == nowVowel) {
                count++;
            } else {
                count = 1;
                nowVowel = isVowel(ch);
            }
            if (count >= 3) return true;
        }
        return false;
    }
}
