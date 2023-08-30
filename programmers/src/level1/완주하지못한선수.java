package level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 완주하지못한선수 {
	public class Solution {
	    public static String solution(String[] participant, String[] completion) {
	    	String answer = "";
	        HashMap<String, Integer> map = new HashMap<>();
	        for (String player : participant) 
	            map.put(player, map.getOrDefault(player, 0) + 1);
	        for (String player : completion) 
	            map.put(player, map.get(player) - 1);

	            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

	        while(iter.hasNext()){
	            Map.Entry<String, Integer> entry = iter.next();
	            if (entry.getValue() != 0){
	                answer = entry.getKey();
	                break;
	            }
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		String ans = Solution.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"});
		System.out.println(ans);
	}
}
