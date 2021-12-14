import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j2605 {
    static int N;
    static List<Integer> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            arr.add(i - sc.nextInt(), i+1);
        }


        for(Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
