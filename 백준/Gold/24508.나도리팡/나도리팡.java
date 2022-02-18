import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 아예 불가능한 경우를 체크
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        if (sum % K != 0 || (sum != 0 && sum < K)) {
            System.out.println("NO");
            return;
        }

        // 입력값 체크
        for (int i = 0; i < N; i++) {
            if(arr[i] >= K) {
                throw new RuntimeException("바구니 하나에 주어진 값은 K보다 항상 작아야합니다");
            }
        }

        Arrays.sort(arr);

        // 투 포인터 접근
        int left = 0, right = N - 1;
        while (left < right) {
            int tmp = arr[left] + arr[right];
            if (tmp < K) { //합해도 적은 경우, 작은쪽을 큰바구니에 털어넣기
                T -= arr[left];
                arr[right] += arr[left];
                arr[left] = 0; // 굳이 초기화할 필요는 없음
                left++;
            } else if (tmp > K) { //합하면 넘치는 경우, 남을것만 털어넣고 정렬까지 해줘야함
                int m = tmp - K; // 남아야하는 양
                T -= Math.min(arr[right] - m, arr[left] - m);
                arr[left] = m;
                arr[right] = 0;
                right--;
                Arrays.sort(arr, left, right);
            }else { // 두 바구니의 합이 K개 인 경우
                T -= arr[left];
                arr[left] = arr[right] = 0;
                left++;
                right--;
            }

            if(T < 0) { // T회 이하로 옮길 수 없는 경우 종료
                System.out.println("NO");
                return;
            }
        }

        // 위의 반복문에 T를 체크하므로 여기까지 통과한 경우는 YES가 됨
        System.out.println("YES");
    }
}
