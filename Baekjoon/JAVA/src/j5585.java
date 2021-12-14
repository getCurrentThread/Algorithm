import java.util.Scanner;

public class j5585 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();
        int cnt = 0;
        int [] arr = new int[] {500, 100, 50, 10, 5, 1};
        for(int i = 0; i < arr.length; i++) {
            cnt += n / arr[i];
            n %= arr[i];
        }
        System.out.println(cnt);
    }
}
