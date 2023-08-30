import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(set.size() == nums.length/2) break;
            if(!set.contains(nums[i])) set.add(nums[i]);
        }

        return set.size();
    }
}