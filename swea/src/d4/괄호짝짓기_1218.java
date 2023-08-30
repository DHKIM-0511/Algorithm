package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기_1218 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1 ; tc <=10 ;tc++) {
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			System.out.println("#"+tc+" "+find(input));
		}
			
	}
	private static int find(String input) {
		Stack<Character> tmp1 = new Stack<>();
		Stack<Character> tmp2 = new Stack<>();
		Stack<Character> tmp3 = new Stack<>();
		Stack<Character> tmp4 = new Stack<>();
		
		for (char c : input.toCharArray()) {
			if(c=='(' || c=='[' || c=='{' || c=='<'  ) {
				if(c=='(') {
					tmp1.push(c);
				}else if(c=='[') {
					tmp2.push(c);
				}else if(c=='{') {
					tmp3.push(c);
				}else if(c=='<') {
					tmp4.push(c);
				}
			} else if (c==')' || c==']' || c=='}' || c=='>') {
				if (c == ')') {
					if(!tmp1.isEmpty())
						tmp1.pop();
					else return 0;
				} else if (c == ']') {
					if(!tmp2.isEmpty())
						tmp2.pop();
					else return 0;
				} else if (c == '}') {
					if(!tmp3.isEmpty())
						tmp3.pop();
					else return 0;
				} else if (c == '>') {
					if(!tmp4.isEmpty())
						tmp4.pop();
					else return 0;
				}
			}
		}
		
		if (tmp1.isEmpty() && tmp2.isEmpty() && tmp3.isEmpty() && tmp4.isEmpty())
			return 1;

		return 0;
	}
}
