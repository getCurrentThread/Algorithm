import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String name;
        int korean;
        int english;
        int math;
        Node(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        public int compareTo(Node o) {
            if(this.korean == o.korean){
                if(this.english == o.english){
                    if(this.math == o.math){
                        return this.name.compareTo(o.name);
                    }else{
                        return -(this.math - o.math);
                    }
                }else{
                    return this.english - o.english;
                }
            }else{
                return -(this.korean - o.korean);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        List<Node> list = new ArrayList<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Node(name, korean, english, math));
        }

        Collections.sort(list);
        for(Node node : list) {
            out.append(node.name).append("\n");
        }
        System.out.print(out);
    }
}