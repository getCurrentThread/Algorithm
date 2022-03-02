import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {
		public int[] solution(String[] operations) {
			int[] answer = new int[2];
			TreeSet<Integer> ts = new TreeSet<>();
			for (int i = 0; i < operations.length; i++) {
				StringTokenizer st = new StringTokenizer(operations[i]);
				if (st.nextToken().equals("I")) {
					ts.add(Integer.parseInt(st.nextToken()));
				} else { // "D"
					if (ts.isEmpty())
						continue;
					if (st.nextToken().equals("1")) { // 최댓값 삭제
						ts.pollLast();
					} else { // 최솟값 삭제
						ts.pollFirst();
					}
				}
			}
			if (ts.isEmpty()) {
				answer[0] = answer[1] = 0;
			} else {
				answer[0] = ts.last();
				answer[1] = ts.first();
			}
			return answer;
		}
	}