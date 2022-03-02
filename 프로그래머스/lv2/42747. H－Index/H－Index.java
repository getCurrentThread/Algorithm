class Solution {
		public int solution(int[] citations) {
			int sums[] = new int[10001];
			for (int i : citations) {
				++sums[i];
			}
			for (int i = 9999; i >= 0; i--) {
				sums[i] = sums[i] + sums[i + 1];
			}
			int i = 0;
			for (; i <= 10000; i++) {
				if (sums[i] < i)
					break;
			}
			return i - 1;
		}
	}