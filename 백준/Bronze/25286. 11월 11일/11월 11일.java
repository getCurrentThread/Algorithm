import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());

            //one day before...
            if (month == 1) {
                year--;
                month = 12;
            } else {
                month--;
            }

            //get the last day of the month
            int lastDay = getLastDay(year, month);
            System.out.println(String.format("%d %d %d", year, month, lastDay));
        }
    }

    private static int getLastDay(int year, int month) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[1] = 29;
        }
        return days[month - 1];
    }
}