import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();

        if(contains(s, p)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
    // s.contains(p), KMP algorithm.
    private static boolean contains(String s, String p) {
        if (s.length() < p.length()) return false;
        int[] next = getNext(p);
        int i = 0, j = 0;
        while(i < s.length() && j < p.length()){
            if(j == -1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        return j == p.length();
    }

    // get the next array of the pattern p.
    private static int[] getNext(String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < p.length() - 1){
            if(j == -1 || p.charAt(i) == p.charAt(j)){
                i++;
                j++;
                if(p.charAt(i) != p.charAt(j)){
                    next[i] = j;
                }else{
                    next[i] = next[j];
                }
            }else{
                j = next[j];
            }
        }
        return next;
    }
}