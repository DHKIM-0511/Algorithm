package 스택_큐;

import java.util.*;

public class Lv2_기능개발 {
	public static int[] solution(int[] progresses, int[] speeds) {
		
        Set<Integer> set = new HashSet<>();
        int minDay = 0;
        int n = progresses.length;
        List<Integer> answerList = new ArrayList<>(); 
        int idx = -1;
        
        for(int i = 0 ; i < n ; i++){
            int cur = progresses[i];
            int day = 0;
            
            while(cur < 100){
                cur += speeds[i];
                day++;
            }
            
            minDay = Math.max(minDay, day);
            
            if(set.contains(minDay)) {
            	answerList.set(idx, answerList.get(idx)+1);
            	
            }else {
            	set.add(minDay);
            	idx+=1;
            	answerList.add(1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i= 0 ; i < answerList.size() ; i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 98, 80, 99};
		int[] speeds= {1, 1, 1, 1, 1, 1};
		int[] answer = solution(progresses, speeds);
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
