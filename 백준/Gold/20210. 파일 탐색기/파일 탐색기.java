import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> naturalCompare(a, b));

        for (int i = 0; i < n; i++) {
            bw.append(arr[i]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static int naturalCompare(final String a, final String b) {
        int al = 0, ar = 0; // a : range[al, ar)
        int bl = 0, br = 0; // b : range[bl, br)
        int diff = 0;
        while (al < a.length() && bl < b.length()) {
            // different type compare... (it must return value)
            if (Character.isDigit(a.charAt(al)) == Character.isAlphabetic(b.charAt(bl))) {
                return Character.isDigit(a.charAt(al)) ? -1 : 1;
            }
            // alphabet compare...
            else if (Character.isAlphabetic(a.charAt(al)) && Character.isAlphabetic(b.charAt(bl))) {
                diff = naturalAlphabetCompare(a.charAt(al), b.charAt(bl));
                if (diff != 0) break;
                ar = al + 1;
                br = bl + 1;
            }
            // digit compare...
            else if (Character.isDigit(a.charAt(al)) && Character.isDigit(b.charAt(bl))) {
                ar = next(a, al, Character::isDigit);
                br = next(b, bl, Character::isDigit);
                diff = naturalNumberCompare(a.substring(al, ar), b.substring(bl, br));
                if (diff != 0) break;
            }
            al = ar;
            bl = br;
        }
        // 두 문자열 둘중의 하나가 단위 그룹을 소진하여 서로 더 이상 비교할 수 없는 경우에 도달한 경우, 소진한 쪽을 앞에 둔다
        if (diff == 0) {
            if (a.length() <= al && b.length() <= bl) return 0;
            else if (a.length() <= al) return -1;
            else if (b.length() <= bl) return 1;
        }
        return diff;
    }

    private static int next(final String a, int pos, Function<Character, Boolean> is) {
        while (pos < a.length()) {
            if (!is.apply(a.charAt(pos))) break;
            ++pos;
        }
        return pos;
    }

    static int naturalNumberCompare(final String a, final String b) {
        BigInteger ai = new BigInteger(a);
        BigInteger bi = new BigInteger(b);

        // 같은 값을 가지는 문자일 경우, 0의 갯수가 적은 것이 앞으로
        if (ai.compareTo(bi) == 0)
            return Integer.compare(a.length(), b.length());
        return ai.compareTo(bi);
    }

    final static String naturalAlphabetOrder = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz"; // 순차적으로 찾는 경우, timeout 이유가 될 수 있음

    static int naturalAlphabetCompare(final char a, final char b) {
        return Integer.compare(naturalAlphabetOrder.indexOf(a), naturalAlphabetOrder.indexOf(b));
    }

//    static int naturalAlphabetCompare(final String a, final String b) {
//        int ia, ib;
//        for (int i = 0; i < a.length() && i < b.length(); i++) {
//            ia = naturalAlphabetOrder.indexOf(a.charAt(i));
//            ib = naturalAlphabetOrder.indexOf(b.charAt(i));
//            if (ia == ib) continue;
//            return Integer.compare(ia, ib);
//        }
//        // 비교할 수 있는 문자열이 지금까지 같았다면, 문자열 길이순으로 정렬
//        return Integer.compare(a.length(), b.length());
//    }
}