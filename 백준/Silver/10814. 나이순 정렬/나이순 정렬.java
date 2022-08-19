import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class PersonFactory {
        static int uid = 0;

        static public Person create(int age, String name) {
            return new Person(uid++, age, name);
        }
    }

    static class Person implements Comparable<Person> {
        int uid;
        int age;
        String name;

        Person(int uid, int age, String name) {
            this.uid = uid;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age)
                return this.uid - o.uid;
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        Person[] arr = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer sb = new StringTokenizer(in.readLine());
            int age = Integer.parseInt(sb.nextToken());
            String name = sb.nextToken();
            arr[i] = PersonFactory.create(age, name);
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            out.append(arr[i].age).append(' ').append(arr[i].name).append('\n');
        }
        System.out.print(out);
    }
}
