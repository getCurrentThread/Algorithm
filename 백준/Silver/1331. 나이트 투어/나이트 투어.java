import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[6][6];
        String start = br.readLine(); // 시작 위치
        String before = start;
        move(map, before);
        for (int i = 0; i < 35; i++) { // 아래로 총 35번 반복
            String next = br.readLine(); // 다음 위치
            if (!isValid(before, next)) {
                System.out.println("Invalid"); // 체스말이 갈 수 없는 위치이다.
                return;
            }
            before = next;
            move(map, before);
        }

        // 끝 지점에서 시작지점으로 갈 수 있는지 체크한다.
        if (!isValid(before, start)) {
            System.out.println("Invalid");
            return;
        }

        // 모든 지점을 방문했는지 체크한다.
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!map[i][j]) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        // 모든 지점을 방문했으므로 정상적인 경로이다.
        System.out.println("Valid");
    }

    private static void move(boolean[][] map, String movement) {
        int x1 = movement.charAt(0) - 'A';
        int y1 = movement.charAt(1) - '1';
        map[x1][y1] = true;
    }

    private static boolean isValid(String before, String next) {
        int mx = Math.abs(before.charAt(0) - next.charAt(0));
        int my = Math.abs(before.charAt(1) - next.charAt(1));
        return 0 < mx && mx < 3
                && 0 < my && my < 3
                && mx + my == 3;
    }
}