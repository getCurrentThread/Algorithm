import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String line = in.readLine();
        String[] subLines = line.split("-");
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < subLines.length; i++) {
            nums.add(Arrays.stream(subLines[i].split("\\+")).mapToInt(Integer::parseInt).sum());
        }

        int result = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            result -= nums.get(i);
        }
        System.out.println(result);
    }

}