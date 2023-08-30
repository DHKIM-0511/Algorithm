package play;

import java.util.HashSet;
import java.util.Set;

public class playground {
	 public int solution(int[] nums) {
		int N = nums.length; 
		Set<Integer> set = new HashSet<>();
		
        for(int i = 0 ; i < N ; i++){
        	if(set.size() == N/2) break;
        	if(!set.contains(nums[i])) set.add(nums[i]); 
        }
        
        return set.size();
    }
}
