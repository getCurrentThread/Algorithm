import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
		public int[] solution(int[] answers) {

			int[][] persons = new int[][] { 
				null, 
				new int[] { 1, 2, 3, 4, 5 }, 
				new int[] { 2, 1, 2, 3, 2, 4, 2, 5 },
				new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
			int[] currect = new int[4];
			for(int i = 0; i < answers.length; i++)
				for(int j = 1; j <= 3; j++) {
					if(answers[i] == persons[j][i%persons[j].length]) {
						++currect[j];
					}
				}
			
			int mx = Arrays.stream(currect).max().getAsInt();
			List<Integer> ans = new ArrayList<Integer> ();
			for(int i = 1; i <= 3; i++) {
				if(currect[i] == mx)
					ans.add(i);
			}
			
			return ans.stream().mapToInt(Integer::intValue).toArray();
		}
	}