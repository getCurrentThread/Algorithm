import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	    	List<Integer> ans = new ArrayList<Integer>();
	    	
	    	for(int [] cmd : commands) {
	    		int[] temp = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
	    		Arrays.sort(temp);
	    		ans.add(temp[cmd[2]-1]);
	    	}
	    	
	    	return ans.stream().mapToInt(Integer::intValue).toArray();
	    }
	}