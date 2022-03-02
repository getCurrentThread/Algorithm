class Solution {
		public int[] solution(int brown, int yellow) {
			int[] answer = new int[2];
			brown += yellow;
			int XplusY = (brown - yellow + 4) / 2;

			// 완전 탐색 x = 1 to (XplusY-1)
			int y;
			for (int x = 1; x < XplusY; x++) {
				y = XplusY - x;
				if(brown / x == y && brown % x == 0) {
					answer[0] = y;
					answer[1] = x;
					break;
				}
			}
			return answer;
		}
	}