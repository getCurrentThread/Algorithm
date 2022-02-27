import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
		public int solution(String[][] clothes) {
			int answer = 0;
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < clothes.length; i++) {
				if (!map.containsKey(clothes[i][1])) {
					map.put(clothes[i][1], 1);
				} else {
					map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
				}
			}
			List<Integer> list = new ArrayList<>();
			for (Entry<String, Integer> entry : map.entrySet()) {
				list.add(entry.getValue());
			}
			answer = subset(list, 0, 0);

			return answer;
		}

		private int subset(List<Integer> numbers, int result, int depth) {
			if (numbers.size() == depth) {
				return result;
			}
			
			int temp = subset(numbers, result, depth + 1);
			return temp + subset(numbers, (result != 0 ? result : 1) * numbers.get(depth), depth + 1);
		}
	}