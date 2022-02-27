import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
	    public int solution(int[] priorities, int location) {
	        Queue<Pair> q = new LinkedList<>();
	        
	        for(int i = 0; i < priorities.length; i++) {
	        	q.offer(new Pair(i, priorities[i]));
	        }
	        List<Integer> pList = Arrays.stream(priorities).boxed()
	        		.sorted(Collections.reverseOrder())
	        		.collect(Collectors.toList());
	        int idx = 0;
	        while(idx < pList.size()) {
		        	if(q.peek().priority == pList.get(idx)) {
	        		if(q.poll().idx == location) {
	        			return idx+1;
	        		}
	        		++idx;
	        	}else {
	        		q.add(q.poll());
	        	}
	        }
	        return -1;
	    }
	    class Pair{
	    	int idx;
	    	int priority;
			public Pair(int idx, int priority) {
				this.idx = idx;
				this.priority = priority;
			}
			@Override
			public String toString() {
				return "Pair [idx=" + idx + ", priority=" + priority + "]";
			}
	    }
	}