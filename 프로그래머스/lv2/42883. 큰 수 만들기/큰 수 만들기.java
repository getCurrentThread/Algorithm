class Solution {
		public String solution(String number, int k) {
			StringBuilder answer = new StringBuilder(number.length() - k);
			int midx, mnum;
			int i;
			for (i = 0; i + k < number.length(); i++) {
				midx = i;
				mnum = number.charAt(i);
				for (int j = 1; j <= k ; j++) {
					if (mnum < number.charAt(i + j)) {
						midx = i + j;
						mnum = number.charAt(i + j);
					}
				}
				k -= midx - i;
				i = midx;
				answer.append(number.charAt(i));
			}
			return answer.toString();
		}
	}