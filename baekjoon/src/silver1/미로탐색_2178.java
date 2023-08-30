package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
	static int n;
	static int m;
	static int cnt = 1;
	static int[][] d = new int[n][m];
	static Queue<dot> q = new LinkedList<>();
	
	public static class dot{
		int x;
		int y;
		
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] maze = new int[n][m];

		
		for(int i = 0 ; i < n ; i ++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				maze[i][j] = tmp.charAt(j)-'0';
			}
		}
		find(maze);
		System.out.println(maze[n-1][m-1]);
	}

	private static void find(int[][] maze) {
		//첫 위치 큐에 추가
		dot d = new dot(0, 0);
		q.offer(d);
		
		while(!q.isEmpty()) {
			//첫위치
			dot d1 = q.poll();
			int x = d1.x;
			int y = d1.y;
			
			int[] dr = {-1 , 1 , 0 , 0};
			int[] dc = { 0 , 0 ,-1 , 1};
			 
			for(int i = 0 ; i < 4 ; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
			
				if(nr >= 0  && nr < n && nc >= 0 && nc < m) {
					if(maze[nr][nc]== 1) {//1일때 이동
						maze[nr][nc] = maze[x][y]+1;//이동하며 값 +1
						dot d2 = new dot(nr, nc);//다음 위치 q에 추가
						q.offer(d2);
					}
				}
			}
		}
		return ;
	}
}
