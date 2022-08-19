import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(in.readLine());
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        heap.addAll((Arrays.stream(c)).boxed().collect(Collectors.toList()));

        for (int i = 0; i < m; i++) {
            int a = heap.poll();
            if (a < w[i]) {
                System.out.println("0");
                return;
            }
            heap.offer(a - w[i]);
        }

        System.out.println("1");
    }
}

