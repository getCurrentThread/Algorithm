import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int H, W, X, Y;

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[][] B = new int[H+X][W+Y];
        for(int i = 0; i < H+X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W+Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] A = new int[H][W];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(i < X || j < Y) {
                    A[i][j] = B[i][j];
                }else{
                    A[i][j] = B[i][j] - A[i-X][j-Y];
                }
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W - 1; j++) {
                bw.write(A[i][j] + " ");
            }
            bw.write(A[i][W-1] + "\n");
        }

        bw.flush();
        bw.close();
    }

}