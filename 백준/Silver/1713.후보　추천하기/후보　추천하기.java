import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Main {
		static int n, m;

		static class Student implements Comparable<Student> {
			private int num, like, order;

			public Student(int num, int like, int order) {
				this.num = num;
				this.like = like;
				this.order = order;
			}

			@Override
			public int compareTo(Student o) {
				if (this.like == o.like) {
					return this.order - o.order;
				} else {
					return this.like - o.like;
				}
			}

			@Override
			public String toString() {
				return "Student [num=" + num + ", like=" + like + ", order=" + order + "]";
			}
		}

		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int n = stoi(in.readLine());
			int m = stoi(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine());
			PriorityQueue<Student> pq = new PriorityQueue<>();
			int order = 1;
			loop: while (st.hasMoreTokens()) {
				int num = stoi(st.nextToken());

				for (Student s : pq) {
					if (s.num == num) {
						s.like++;
						pq = new PriorityQueue<Student>(new ArrayList(pq));
						continue loop;
					}
				}
				if (pq.size() >= n) {
					pq.poll();
				}
				pq.offer(new Student(num, 1, order++));	
			}
			
			IntStream istream = pq.stream().mapToInt(o -> o.num).sorted();
			StringBuilder sb = new StringBuilder();
			for (int num : istream.toArray()) {
				sb.append(num + " ");
			}
			System.out.println(sb.toString().trim());

		}

		static int stoi(String s) {
			return Integer.parseInt(s);
		}
	}
