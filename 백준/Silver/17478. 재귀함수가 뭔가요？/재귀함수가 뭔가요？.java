import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        out.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recurvise(N, 0, out);
        System.out.print(out);
    }

    private static void recurvise(final int N, int depth, StringBuilder out) {
        print(out, depth, "\"재귀함수가 뭔가요?\"\n");
        if (depth == N) {
            print(out, depth, "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            print(out, depth, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            print(out, depth, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            print(out, depth, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            recurvise(N, depth + 1, out);
        }
        print(out, depth, "라고 답변하였지.\n");
    }

    private static void print(final StringBuilder out, final int depth, final String s) {
        for (int i = 0; i < depth; i++)
            out.append("____");
        out.append(s);
    }
}
