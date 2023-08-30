package 정렬;

import java.util.PriorityQueue;

public class Lv1_K번째수 {
	 public int[] solution(int[] array, int[][] commands) {
	        
	        int n = commands.length;
			int[] answer = new int[n];
	        
			for(int i = 0 ; i < n ; i++) {
				PriorityQueue<Integer> tmp = new PriorityQueue<>();
				
				for(int j = commands[i][0]-1 ; j <= commands[i][1]-1 ; j++) 
					tmp.offer(array[j]);
				
				for(int k = 0 ;k < commands[i][2]-1;k++)
	                tmp.remove();
				answer[i] = tmp.poll();
			}
	        
	        
	        return answer;
	    }
}
