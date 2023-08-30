package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

		//1 2 3 4 5 6 7 8 - arr

//by	  1 2 3 4  
//ans

		//4 3 6 8 7 5 2 1 - 인풋
//1~ n 수열

public class 스택수열_1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int start = 0;
		
		for(int i = 0 ; i < n ;i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp > start) {
				for(int j = start+1  ; j <= tmp ; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				start = tmp;
			}else if(stack.peek() != tmp) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
		
	}
}
