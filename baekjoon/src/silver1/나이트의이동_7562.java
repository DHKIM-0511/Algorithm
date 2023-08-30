package silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동_7562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ;tc++) {
			int ans = 0;
			int n = sc.nextInt();
			
			boolean[][] map = new boolean[n][n];
			int[] idx = {sc.nextInt() , sc.nextInt(),ans};
			int[] targetIdx= {sc.nextInt(),sc.nextInt()};
			// bfs실행
			
			Queue<int[]> q = new LinkedList<>();
			q.add(idx);
			int[] dr = {-2,-1, 1, 2, 2, 1,-1,-2};
			int[] dc = {-1,-2,-2,-1, 1, 2, 2, 1};
			
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				
				 if(tmp[0] == targetIdx[0] && tmp[1] == targetIdx[1]) {
				        ans = tmp[2];
				        break;
				    }
				 
				for(int i = 0 ; i< 8 ; i++) {
					int nr = tmp[0] + dr[i];
					int nc = tmp[1] + dc[i];
					
					if(nr < n && nr >= 0 && nc < n && nc >= 0 && map[nr][nc] == false) {
						int[] temp = {nr,nc,tmp[2]+1};
						q.add(temp);
						map[nr][nc] = true;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
