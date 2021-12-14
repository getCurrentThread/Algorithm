import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j2635 {
    private static int[] simulate(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int i = n;
        while(i > 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(n);
            temp.add(i);
            int before = n;
            int current = i;
            int next = before - current;
            while(next >= 0) {
                temp.add(next);
                before = current;
                current = next;
                next = before - current;
            }

            if(result.size() < temp.size()) {
                result = temp;
            }
            i--;
        }
        int[] rsult = new int[result.size()];
        for(int j = 0; j < result.size(); j++) {
            rsult[j] = result.get(j);
        }
        return rsult;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] result = simulate(n);

        System.out.println(result.length);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
