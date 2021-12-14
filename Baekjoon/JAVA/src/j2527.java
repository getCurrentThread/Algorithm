import java.util.Scanner;



public class j2527 {
    static class Square{
        int x1;
        int y1;
        int x2;
        int y2;

    }
    private static char checkDuplicate(Square a, Square b) {
        int x1 = Math.max(a.x1, b.x1);
        int y1 = Math.max(a.y1, b.y1);
        int x2 = Math.min(a.x2, b.x2);
        int y2 = Math.min(a.y2, b.y2);
        if(x1 > x2 || y1 > y2) return 'd';
        else if(x1 == x2 && y2 == y1) return 'c';
        else if(x1 == x2 || y2 == y1) return 'b';
        else if(x1 < x2 && y1 < y2) return 'a';
        return 'e';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++) {
            Square a = new Square(), b = new Square();
            a.x1 = sc.nextInt();
            a.y1 = sc.nextInt();
            a.x2 = sc.nextInt();
            a.y2 = sc.nextInt();
            b.x1 = sc.nextInt();
            b.y1 = sc.nextInt();
            b.x2 = sc.nextInt();
            b.y2 = sc.nextInt();
            System.out.println(checkDuplicate(a, b));
        }
    }

}
