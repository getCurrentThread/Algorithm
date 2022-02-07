import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[][] mapping = new String[][]{{"ZERO", "0"}, {"ONE", "1"}, {"TWO", "2"}, {"THREE", "3"}, {"FOUR", "4"}, {"FIVE", "5"}, {"SIX", "6"}, {"SEVEN", "7"}, {"EIGHT", "8"}, {"NINE", "9"}};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine().trim();

        for (int i = 0; i < mapping.length; i++) {
            line = line.replace(mapping[i][0], mapping[i][1]);
        }

        // '=' 기호가 이상한 곳에 배치되어 있는 경우 제거
        if (line.charAt(line.length() - 1) != '=' || line.indexOf('=') != line.lastIndexOf('=')) {
            System.out.println("Madness!");
            return;
        }


        String[] number = line.split("[x\\+\\-\\/\\=]");
        String[] operator = line.split("[0-9]+");

        // 피연산자가 모두 배치되어 있는지 확인
        if (number.length + 1 != operator.length) {
            System.out.println("Madness!");
            return;
        }
        for(int i = 0; i < number.length; i++) {
            if(number[i].length() == 0) {
                System.out.println("Madness!");
                return;
            }
            try{
                Long.parseLong(number[i]);
            }catch (NumberFormatException e) {
                System.out.println("Madness!");
                return;
            }
        }

        long result = Long.parseLong(number[0]);
        for (int i = 1; i < operator.length - 1; i++) {
            switch (operator[i]) {
                case "x":
                    result *= Long.parseLong(number[i]);
                    break;
                case "+":
                    result += Long.parseLong(number[i]);
                    break;
                case "-":
                    result -= Long.parseLong(number[i]);
                    break;
                case "/":
                    result /= Long.parseLong(number[i]);
                    break;
                default:
                    System.out.println("Madness!");
                    return;
            }
        }

        System.out.println(line);
        String answer = Long.toString(result);
        for (int i = 0; i < mapping.length; i++) {
            answer = answer.replace(mapping[i][1], mapping[i][0]);
        }
        System.out.println(answer);
    }
}