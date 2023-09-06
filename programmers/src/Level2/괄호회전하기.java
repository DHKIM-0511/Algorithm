package Level2;

import java.util.*;

public class 올바른괄호 {
	class Solution {
		boolean solution(String s) {
			char[] input = s.toCharArray();
			Stack<Character> stack = new Stack<>();

			for(char c : input){
				if(c == '('){
					stack.push(c);
				}else{
					if(stack.size() == 0){
						return false;
					}
					stack.pop();
				}
			}
			if(stack.size() != 0 ) return false;

			return true;
		}
	}
}
