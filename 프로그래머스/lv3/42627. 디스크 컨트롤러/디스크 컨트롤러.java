import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
		public int solution(int[][] jobs) {
			List<Integer> answer = new ArrayList<Integer>();
			PriorityQueue<Node> wq = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));
			PriorityQueue<Node> tq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
			for (int i = 0; i < jobs.length; i++) {
				wq.offer(new Node(jobs[i][0], jobs[i][1]));
			}
			int time = 0;
			Node node;
			while (!wq.isEmpty() || !tq.isEmpty()) {
				if (tq.isEmpty() && !wq.isEmpty() && time < wq.peek().start) { // 작업 큐가 비어있다면, wq에서 시작할 수 있는 시간으로 이동
					time = wq.peek().start;
				}
				while (!wq.isEmpty() && wq.peek().start <= time) {
					tq.offer(wq.poll());
				}

				if (!tq.isEmpty()) {
					node = tq.poll();
					answer.add(time - node.start + node.time);
					time = time + node.time;
				}
			}
			//System.out.println(answer.toString());

			return (int) Math.floor(answer.stream().mapToInt(Integer::intValue).average().orElse(0.0));
		}

		class Node {
			int start;
			int time;

			public Node(int start, int time) {
				this.start = start;
				this.time = time;
			}
		}
	}