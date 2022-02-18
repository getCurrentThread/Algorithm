import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
        System.out.println(String.format("%02d", calendar.get(Calendar.DATE)));
    }
}
