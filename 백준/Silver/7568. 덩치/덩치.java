import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Person implements Comparable<Person> {
        int idx;
        int weight;
        int height;

        public Person(int idx, int weight, int height) {
            this.idx = idx;
            this.weight = weight;
            this.height = height;
        }

        public int compareTo(Person p) {
            if (this.weight > p.weight && this.height > p.height) return 1;
            else if (this.weight < p.weight && this.height < p.height) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            people[i] = new Person(i, Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        for (int i = 0; i < n; i++) {
            Person p = people[i];
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && p.compareTo(people[j]) < 0) {
                    rank++;
                }
            }
            out.append(rank).append(" ");
        }

        System.out.print(out);
    }

//    private static void reverse(Person[] people) {
//        int i = 0;
//        int j = people.length - 1;
//        while (i < j) {
//            swap(people, i, j);
//            i++;
//            j--;
//        }
//    }
//
//    private static void qsort(Person[] people, int left, int right) {
//        if (left >= right) return;
//        int pivot = partition(people, left, right);
//        qsort(people, left, pivot - 1);
//        qsort(people, pivot + 1, right);
//    }
//
//    private static int partition(Person[] people, int left, int right) {
//        Person pivot = people[left];
//        int i = left + 1;
//        int j = right;
//        while (true) {
//            while (i <= right && people[i].compareTo(pivot) <= 0) i++;
//            while (j >= left + 1 && people[j].compareTo(pivot) > 0) j--;
//            if (i > j) break;
//            swap(people, i, j);
//        }
//        swap(people, left, j);
//        return j;
//    }
//
//    private static void swap(Person[] people, int i, int j) {
//        Person tmp = people[i];
//        people[i] = people[j];
//        people[j] = tmp;
//    }
}