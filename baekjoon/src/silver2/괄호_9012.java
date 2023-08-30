package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			if(isVPS(str)) {
				System.out.println("YES");	
			}else
				System.out.println("NO");
		}
	}

	private static boolean isVPS(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i= 0 ; i <str.length()-1 ; i++) {
			char c = str.charAt(i);
			if(c == '(')
				stack.push(c);
			else {
				if(stack.isEmpty())
					return false;
				stack.pop();
			}	
		}
		
		if(str.charAt(str.length()-1) == '(')
			return false;
		else {
			if(stack.isEmpty())
				return false;
			stack.pop();
		}
		
		
		if(!stack.isEmpty())
			return false;
		
		return true;
	}
}
