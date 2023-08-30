package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<n ; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i <n ; i++) {
			//스택이 비어있지않고, A[스택의 top] < A[i] 인 경우 A[i]값으로 변경
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				A[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) { // 오큰수를 찾지못한 idx는 -1
			A[stack.pop()] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(A[i]).append(' ');
		}
		System.out.println(sb); 
	}
}





////비교 인덱스
//		int start = 0;
//		stack.push(Integer.parseInt(st.nextToken())); // 5 7
//		
//		while(true) {
//			int next;
//			if(st.hasMoreTokens()) {
//				 next = Integer.parseInt(st.nextToken()); // 5 2 7
//			}else if(stack.size()!=1)
//				next = stack.pop();
//			
//			if(next > stack.peek()) { 
//				NGE[start++] = next;  // 5 7
//				stack.pop();
//				stack.push(next);
//				
//			}else
//				stack.push(next);
//		}
//		//NGE(i+1) ~ NGE(N) 을 공백띄고 출력
//		
//		sb.append(-1);