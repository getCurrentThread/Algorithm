import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        Map<Long, Integer> map = new HashMap<>();

        long num;
        for(int i = 0; i < N; i++){
            num = Long.parseLong(in.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long mkey = Integer.MAX_VALUE; //카드 번호
        int mvalue = 0; //카운트 수
        for(final Map.Entry<Long, Integer> entry : map.entrySet()){
            final long key = entry.getKey();
            final int value = entry.getValue();
            if((mvalue < value) || (mvalue == value && mkey > key)){
                mkey = key;
                mvalue = value;
            }
        }
        System.out.println(mkey);
    }
}
