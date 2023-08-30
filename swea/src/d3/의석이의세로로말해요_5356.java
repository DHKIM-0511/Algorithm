package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class 의석이의세로로말해요_5356 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			
			String str = br.readLine();
			
			Stack<Character> stack1 = new Stack<>();
			for(int j = str.length()-1 ; j >= 0 ; j--) {
				stack1.push(str.charAt(j));
			}
			str = br.readLine();
			Stack<Character> stack2 = new Stack<>();
			for(int j = str.length()-1 ; j >= 0 ; j--) {
				stack2.push(str.charAt(j));
			}
			
			str = br.readLine();
			Stack<Character> stack3 = new Stack<>();
			for(int j = str.length()-1 ; j >= 0 ; j--) {
				stack3.push(str.charAt(j));
			}
			
			str = br.readLine();
			Stack<Character> stack4 = new Stack<>();
			for(int j = str.length()-1 ; j >= 0 ; j--) {
				stack4.push(str.charAt(j));
			}
			
			str = br.readLine();
			Stack<Character> stack5 = new Stack<>();
			for(int j = str.length()-1 ; j >= 0 ; j--) {
				stack5.push(str.charAt(j));
			}
			
			StringBuilder sb = new StringBuilder();
			while(true) {
				if(!stack1.isEmpty())
					sb.append(stack1.pop());
				if(!stack2.isEmpty())
					sb.append(stack2.pop());
				if(!stack3.isEmpty())
					sb.append(stack3.pop());
				if(!stack4.isEmpty())
					sb.append(stack4.pop());
				if(!stack5.isEmpty())
					sb.append(stack5.pop());
				if(stack1.isEmpty()&&stack2.isEmpty()&&stack3.isEmpty()&&stack4.isEmpty()&&stack5.isEmpty())
					break;
			}
			System.out.println("#"+tc+" "+sb);
		}
	}
}
