package gold4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2_12851 {
	static int k , time , cnt;
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		k = sc.nextInt();
		Queue<int[]> q = new LinkedList<int[]>();
		
		time = cnt = 0;
		q.add(new int[] {n,time});
		
		BFS(q);
		System.out.println(time);
		System.out.println(cnt);
	}
	private static void BFS(Queue<int[]> q) {
		
		while(!q.isEmpty()) {
			
			int[] tmp = q.poll();
			visited[tmp[0]] = true;
			
			if(cnt>=1 && tmp[1] > time) {
				return;
			}
			if(tmp[0] == k) {
				cnt++;
				time = tmp[1];
			}
			int[] nextIdx = {tmp[0]-1 , tmp[0]+1 , tmp[0]*2};
			
			for(int i = 0 ; i < 3 ; i++) {
				if(nextIdx[i] >= 0 && nextIdx[i] <=100000 && !visited[nextIdx[i]]) {
					q.add(new int[] {nextIdx[i],tmp[1]+1});
				}
			}
		}
	}
}
