package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int a = 0;
		
		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			
			if(tmp.equals("push")) {
				a = Integer.parseInt(st.nextToken());
				stack.push(a);
			}else if(tmp.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.pop()); 
				}	
			}else if(tmp.equals("size")) {
				System.out.println(stack.size());
			}else if(tmp.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0); 
				}	
			}else if(tmp.equals("top")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.peek()); 
				}
			}
		}
	}
}
