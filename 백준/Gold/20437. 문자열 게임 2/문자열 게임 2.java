import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int[] ret = solve(w, k);
            if (ret == null) {
                System.out.println(-1);
            } else {
                System.out.println(String.format("%d %d", ret[0], ret[1]));
            }
        }
    }

    static final int AtoZ = 'z' - 'a' + 1;

    private static int[] solve(final String w, final int k) {
        int ans3 = Integer.MAX_VALUE, ans4 = Integer.MIN_VALUE;
        char[] arr = w.toCharArray();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= AtoZ; i++) {
            list.add(new ArrayList<>());
        }

        // (letters -> index) matching list. (like graph)
        for (int i = 0; i < arr.length; i++) {
            list.get(arr[i] - 'a').add(i);
        }


        int size;
        for (int i = 0; i < AtoZ; i++) {
            final List<Integer> letter = list.get(i);
            // pick one of letters that count >= k.
            if ((size = letter.size()) >= k) {
                // get one letter (one of 'a' ~ 'z'), testing two-point.
                for (int j = k; j <= size; j++) {
                    ans3 = Math.min(ans3, letter.get(j - 1) - letter.get(j - k) + 1);
                    ans4 = Math.max(ans4, letter.get(j - 1) - letter.get(j - k) + 1);
                }
            }
        }


        if (ans3 == Integer.MAX_VALUE || ans4 == Integer.MIN_VALUE) {
            return null;
        }
        return new int[]{ans3, ans4};
    }
}