package silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697 {
	static int n, k ;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		find();
		System.out.println(ans); 
		
	}
	private static void find() {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[100001];
		q.add(new int[] {n , 0});
		visited[n] = true;
		
		while(!q.isEmpty()){
			int[] tmp = q.poll();
			
			if(tmp[0] == k) {
				ans = tmp[1];
				return;
			}else {
				int[] nextIdx = {tmp[0] * 2, tmp[0] + 1, tmp[0] - 1};
				
				for (int i = 0; i < nextIdx.length; i++) {
	                int next = nextIdx[i];
	                
	                if (next >= 0 && next <= 100000 && !visited[next]) {
	                    q.add(new int[]{next, tmp[1] + 1});
	                    visited[next] = true;
	                }
	            }
			}
		}
	}
}
