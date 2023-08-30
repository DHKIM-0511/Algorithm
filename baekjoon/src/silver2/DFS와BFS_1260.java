package silver2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS와BFS_1260 {
	
	static StringBuilder sb = new StringBuilder();
	static int n , m ,v;
	static boolean[][] adge;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();		
		Queue<Integer> q = new LinkedList<Integer>();
		
		stack.push(v);
		q.add(v);
		
		adge = new boolean[n+1][n+1];
		
		for(int i = 0 ; i < m ; i++) { //간선 연결 저장 
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adge[a][b] = true;
			adge[b][a] = true;
		}
		DFS(stack);
		BFS(q);
		System.out.println(sb);
	}
	private static void DFS(Stack<Integer> stack) {
		boolean[] visited = new boolean[n+1];
		
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			visited[tmp] = true;
			sb.append(tmp).append(" ");
			for(int i = n ; i >= 1; i--) {
				if((adge[tmp][i] || adge[i][tmp]) && !visited[i]) {
					stack.push(i);
					visited[i] = true;
					break;
				}
			}
		}
		sb.append("\n");
	}
	private static void BFS(Queue<Integer> q) {
		boolean[] visited = new boolean[n+1];
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			visited[tmp] = true;
			sb.append(tmp).append(" ");
			for(int i = 1 ; i <= n; i++) {
				
				if(adge[tmp][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}	
	}
}
