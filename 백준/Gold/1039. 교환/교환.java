import java.io.*;
import java.util.*;

/*
input:
16375 1

output:
76315
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = solution(N, K);
        System.out.println(ans);
    }


    private static int solution(final int N, int K) {
        int number = N;
        int len = Integer.toString(number).length();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(number);

        while(!q.isEmpty()){
            int qSize = q.size();
            Set<Integer> set = new HashSet<>();
            while(qSize-- > 0){ // 1-depth만큼 순회
                int cur = q.poll();

                //모든 경우를 스왑해보며 조건 만들기
                for(int i = 0; i < len; i++){
                    for(int j = i + 1; j < len; j++){
                        int next = swap(cur, i, j);
                        if(next < 0 || set.contains(next))
                            continue;
                        set.add(next);
                        q.add(next);
                    }
                }
            }
            if(--K <= 0) break;
        }

        if(K != 0)
            return -1;

        int ans = -1;
        while(!q.isEmpty()){
            int next = q.poll();
            if(ans < next)
                ans = next;
        }
        return ans;
    }

    private static int swap(int cur, int i, int j) {
        char[] arr = Integer.toString(cur).toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        if(arr[0] == '0') return -1; // 만약 맨앞의 수가 0이 된다면 잘못된 값이므로 -1 반환
        return Integer.parseInt(new String(arr));
    }
}