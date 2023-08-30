package silver3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_2606 {
	static int map[][];		
	static boolean visit[];	
	static int n, m, v;		
	static int count = 0;	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	
		m = sc.nextInt();	
		v = 1;	
		map = new int[n+1][n+1];	
		visit = new boolean[n+1];	
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a]= 1;
		}
		System.out.println(bfs(1));
	}
	
	public static int bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visit[i] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int k=1; k<=n; k++) {
				if(map[temp][k] == 1 && visit[k] == false) {
					q.offer(k);
					visit[k] = true;
					count ++;
				}
			}
		}
		
		return count;
	}

}