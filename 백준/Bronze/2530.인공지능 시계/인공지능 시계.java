import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());

        int hours = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int seconds = Integer.parseInt(st.nextToken());

        int time = hours * 3600 + minutes * 60 + seconds;
        time += Integer.parseInt(in.readLine());

        hours = time / 3600 % 24;
        minutes = (time % 3600) / 60;
        seconds = (time % 3600) % 60;

        System.out.println(hours + " " + minutes + " " + seconds);
    }
}
