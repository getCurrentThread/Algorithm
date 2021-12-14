import java.util.Scanner;

public class j18512 {
    static int X, Y, H1, H2; // 보폭 X, Y와 출발점 위치 H1, H2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //입력을 받기 위한 Scanner 객체 생성
        X = sc.nextInt(); // 보폭 X 입력
        Y = sc.nextInt();// 보폭 Y 입력
        H1 = sc.nextInt();// 출발점 위치 H1 입력
        H2 = sc.nextInt();// 출발점 위치 H2 입력

        while (H1 < 10000 && H2 < 10000) { // H1, H2 위치가 10000을 넘게 될때까지 반복
            if (H1 == H2)// 서로 같게 된다면
                break;	 // 반복 종료.
            if (H1 > H2) // H1이 더 앞에 있다면
                H2 += Y; // H2를 보폭 Y만큼 이동.
            else 		 // H2가 더 앞에 있다면
                H1 += X; // H1을 보폭 X만큼 이동.
        }
        if (H1 < 10000 && H1 == H2)	//H1과 H2 위치가 서로 같다면
            System.out.println(H1); //위치값 출력.
        else						//아니라면
            System.out.println(-1);	//-1 출력.

        sc.close();
    }
}
