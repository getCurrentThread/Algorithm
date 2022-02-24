class Solution {
		public long solution(int w, int h) {
			return (w * (long) h) - (w + h - lcd(w, h));
		}

		int lcd(int a, int b) {
			if (b == 0)
				return a;
			return lcd(b, a % b);
		}
	}