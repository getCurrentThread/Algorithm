import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
		public int solution(int n, int[][] costs) {
			int answer = 0;
			List<List<Node>> graphs = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				graphs.add(new ArrayList<>());
			}

			int u, v, w;
			for (int i = 0; i < costs.length; i++) {
				u = costs[i][0];
				v = costs[i][1];
				w = costs[i][2];
				graphs.get(u).add(new Node(v, w));
				graphs.get(v).add(new Node(u, w));
			}

			// prim
			boolean visited[] = new boolean[n];

			visited[0] = true;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i < graphs.get(0).size(); i++) {
				pq.offer(graphs.get(0).get(i));
			}
			
			int cnt = 1;
			Node node;
			while (!pq.isEmpty()) {
				node = pq.poll();
				if(visited[node.v]) continue;
				visited[node.v] = true;
				answer += node.w;
				if(++cnt == n) break;
				for(int i = 0; i < graphs.get(node.v).size(); i++) {
					pq.offer(graphs.get(node.v).get(i));
				}
			}
			return answer;
		}
	}

	class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}