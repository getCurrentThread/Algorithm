import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A[i][j] = i * j (N * N), 일 때에 모든 요소를 일차원 배열 B에 넣고 정렬하였을 때에
        // 주어진 k의 B[k] 값을 출력하는 문제
        // 입력으로 주어지는 N, k (1 <= N <= 100000, 1 <= k <= N * N)
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(solution(N, k));
    }

    private static long solution(final int N, final int k) {
        long left = 1, right = k, mid;

        // 이분 탐색
        while (left < right) {
            mid = (left + right) / 2;
            long count = upperBoundOfArrayB(N, mid);
            if (k <= count) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static long upperBoundOfArrayB(final long n, final long target) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.min(target / i, n);
        }
        return sum;
    }
}