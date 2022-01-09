import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());

        int N =  Integer.parseInt(st.nextToken());
        long B =  Long.parseLong(st.nextToken());

        Mat mat = new Mat(N);
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                mat.arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        Mat answer = multipleMatrix(mat, B);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - 1; j++){
                out.append(answer.arr[i][j]).append(' ');
            }
            out.append(answer.arr[i][N-1]).append('\n');
        }
        System.out.print(out);
    }

    static class Mat implements Cloneable {
        int[][] arr;

        public Mat(final int N){
            arr = new int[N][N];
        }
        public Mat mult(Mat mat){
            final int N = this.arr.length;
            Mat rsult = new Mat(N);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < N; k++){
                        rsult.arr[i][j] += arr[i][k] * mat.arr[k][j];
                    }
                    rsult.arr[i][j] %= 1000;
                }
            }
            return rsult;
        }

    }

    private static Mat multipleMatrix(final Mat mat, final long B) {
        if(B == 1)
            return mat;
        if(B % 2 == 0){ //짝수 인 경우 자기 자신의 곱
            return multipleMatrix(mat.mult(mat), B / 2);
        }else{
            return mat.mult(multipleMatrix(mat.mult(mat), (B - 1) / 2));
        }
    }
}
