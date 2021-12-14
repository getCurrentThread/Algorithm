
import java.util.Scanner;

public class j2578 {
    static int[][] board;
    static final int N = 5;
    static int bingoCnt = 0;
    public static void checkBingo(int i, int j) {
        board[i][j] = -1;
        int r;
        for(r = 0; r < 5; r++) {
            if(board[r][j] != -1) {
                break;
            }
        }
        if(r == 5) bingoCnt++;
        for(r = 0; r < 5; r++) {
            if(board[i][r] != -1) {
                break;
            }
        }
        if(r == 5) bingoCnt++;
        if(i == j) { // \대각선 체크
            for(r = 0; r <5; r++) {
                if(board[r][j] != -1) {
                    break;
                }
            }
            if( r== 5) bingoCnt++;
        }
        if(i == 5-j-1) { // /대각선 체크
            for(r = 0; r < 5; r++) {
                if(board[r][5-r-1] != -1) {
                    break;
                }
            }
            if(r == 5) bingoCnt++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[N][N];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                board[i][j] =sc.nextInt();
            }
        }

        for(int k = 1; k <= 25; k++) {
            int tmp = sc.nextInt();
            outer:
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5;j ++) {
                    if(board[i][j] == tmp) {
                        checkBingo(i, j);
                        break outer;
                    }
                }
            }
            if(bingoCnt >= 3) {
                System.out.println(k);
                break;
            }
        }
    }
}
