package study;

import java.util.*;

public class Main {
	public static void main(String[] args){
		int[] arr = {1,1,3,3,0,1,1};
		 Stack<Integer> s = new Stack<>();
	        s.push(arr[0]);
	        
	        for(int i = 1 ; i < arr.length ; i++){
	            if(s.peek() != arr[i]){
	                s.push(arr[i]);        
	            }
	        }
	        int n = s.size();
	        int[] answer = new int[n];
	        
	        for(int i = n-1 ; i>= 0; i--){
	            answer[i] = s.pop();
	        }
	        for(int i : answer) System.out.println(i);
	}
}
