package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {
	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	static class idx{
		int r,c,cnt;

		public idx(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		idx start = null;
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) start = new idx(i, j, 0); 
			}
		}
		BFS(start);
		
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					map[i][j]=-1;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void BFS(idx start) {
		Queue<idx> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			map[cur.r][cur.c] = cur.cnt;
			
			for(int i = 0 ; i < 4;i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr < n && nc >=0 && nc <m && !visited[nr][nc]) {
					if(map[nr][nc] == 1) {
						
						q.add(new idx(nr, nc, cur.cnt+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}












