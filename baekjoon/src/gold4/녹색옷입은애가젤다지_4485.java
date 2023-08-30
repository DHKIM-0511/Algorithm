package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
	public static class idx implements Comparable<idx>{
		int r,c,w;
		public idx(int r, int c,int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(idx o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc =1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			int[][] map = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			int[][] distance = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j< n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<idx> pq = new PriorityQueue<>();
			pq.add(new idx(0, 0, map[0][0]));
			distance[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				idx cur = pq.poll();
				int r = cur.r;
				int c = cur.c;
				
				if(visited[r][c]) continue;
				visited[r][c] = true;
				
				int[] dr = {-1 , 1 , 0, 0};
				int[] dc = {0 , 0 , -1, 1};
				for(int i = 0 ; i < 4 ; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr >= 0 && nr < n && nc >=0 && nc <n) {
						if(distance[nr][nc] > distance[r][c] + map[nr][nc]) {
							distance[nr][nc] = distance[r][c] + map[nr][nc];
							pq.add(new idx(nr, nc , distance[nr][nc]));
						}
					}
				}
			}
			int ans = distance[n-1][n-1];
			System.out.println("Problem "+tc+": "+ans);
			tc++;
		}
	}
}
