import java.util.PriorityQueue;

class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];

			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for (int sec = 0; sec < prices.length; sec++) {
				while ((!pq.isEmpty()) && pq.peek().price > prices[sec]) {
					int nSec = pq.poll().sec;
					answer[nSec] = sec - nSec;
				}
				pq.add(new Pair(sec, prices[sec]));
			}
			while (!pq.isEmpty()) {
				int sec = pq.poll().sec;
				answer[sec] = prices.length - 1 - sec;
			}

			return answer;
		}

		class Pair implements Comparable<Pair> {
			int sec;
			int price;

			public Pair(int sec, int price) {
				this.sec = sec;
				this.price = price;
			}

			@Override
			public int compareTo(Pair o) {
				return Integer.compare(o.price, this.price);
			}
		}
	}