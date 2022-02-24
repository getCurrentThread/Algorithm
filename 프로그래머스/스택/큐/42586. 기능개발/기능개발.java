import java.util.ArrayList;
import java.util.List;

class Solution {
public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < progresses.length; i++) {
        	progresses[i] = (int)Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }
        
        int mx = progresses[0];
        int cnt = 0;
        for(int i  =0; i < progresses.length; i++) {
        	if(mx >= progresses[i]) {
        		cnt++;
        	}else {
        		ans.add(cnt);
        		cnt = 1;
        		mx = progresses[i];
        	}
        }
        ans.add(cnt);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        return answer;
    }
}