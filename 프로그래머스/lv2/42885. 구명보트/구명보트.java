import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

	class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;
			Arrays.sort(people);
//			List<Integer> iArr = new ArrayList<>(people.length);
			Deque<Integer> iArr = new ArrayDeque<>(people.length);
			for (int i = 0; i < people.length; i++) {
				iArr.add(people[i]);
			}

//			int val = 0;
			int capacity = 0;
//			int count = 0;
			while (iArr.size() != 0) {
				++answer;
				/*capacity = limit;
				count = 0;
				while (++count <= 2) {
					val = Collections.binarySearch(iArr, capacity);
					if (val == -1)
						break;
					val = val >= 0 ? val : ~val - 1;
					capacity -= iArr.remove(val);
				}*/
				capacity = limit - iArr.pollLast();
				if(!iArr.isEmpty() && capacity >= iArr.getFirst()) {
					iArr.pollFirst();
				}
			}

			return answer;
		}
	}