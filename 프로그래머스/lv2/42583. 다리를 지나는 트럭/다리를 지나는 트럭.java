import java.util.LinkedList;
import java.util.Queue;

class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			int sec = 0;
			int widx = 0;
			Queue<Pair> q = new LinkedList<>();
			while (true) {
				sec++;
				if ((!q.isEmpty()) && q.peek().sec == sec) { // 다리에서 내릴 때가 된 차량 하차.
					Pair truck = q.poll();
					weight += truck.weight;
					System.out.println("sec:" + sec + ",weight:" + truck.weight);
				}
				if (q.size() < bridge_length) { // 다리에 아직 빈자리가 남는 경우
					if (widx != truck_weights.length && weight >= truck_weights[widx]) { // 대기하고 있는 차량이 있는 경우
						weight -= truck_weights[widx];
						q.add(new Pair(sec + bridge_length, truck_weights[widx++]));
					}
				}
				if (widx == truck_weights.length && q.isEmpty())
					break;
			}
			return sec;
		}

		class Pair {
			int sec;
			int weight;

			public Pair(int sec, int weight) {
				this.sec = sec;
				this.weight = weight;
			}
		}
	}