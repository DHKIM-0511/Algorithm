package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("."))
				break;
			
			if(check(tmp))
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}

	private static boolean check(String tmp) {
		Stack<Character> s = new Stack<>(); 
		 
		for(int i = 0 ; i < tmp.length() ; i++) {
			char c = tmp.charAt(i);
			
			if( c == '(' || c=='[') {
				s.push(c);
			}else if(c == ')' || c==']') {
				if(c == ')') {
					if(s.isEmpty() || s.peek()=='[')
						return false;
					else
						s.pop();
				}else {
					if(s.isEmpty()|| s.peek()=='(')
						return false;
					else
						s.pop();
				}
			}
		}
		if(!s.isEmpty())
			return false;
		
		return true;
	}
}
