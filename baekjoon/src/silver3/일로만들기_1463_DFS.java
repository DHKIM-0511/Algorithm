package silver3;

import java.util.Scanner;
import java.util.Stack;

public class 일로만들기_1463_DFS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(dfs(n));
	}
	private static int dfs(int n) {
		int ans = Integer.MAX_VALUE;
		Stack<int[]> stack = new Stack<>();
		int[] arr = {n,0};
		stack.push(arr);
		
		while(!stack.isEmpty()) {
			int[] tmp = stack.pop();
			
			if(tmp[0] == 1) {
				ans = Math.min(ans, tmp[1]);
				continue;
			}
			
			if(tmp[0] % 3 == 0) {
				int[] temp = {tmp[0] / 3 , tmp[1]+1};
				stack.push(temp);
			}
			if (tmp[0] % 2 == 0) {
				int[] temp = {tmp[0] / 2 , tmp[1]+1};
				stack.push(temp);
			}
				int[] temp = {tmp[0] - 1 , tmp[1]+1};
				stack.push(temp);
			
		}
		return ans;
	}
}
