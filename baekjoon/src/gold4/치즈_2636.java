package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636 {
	static int R,C,time,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
	static class idx{
		int r,c,t;

		public idx(int r, int c,int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0 ;i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt=0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 1 && !visited[R][C]) {
					BFS(new idx(i, j,0));
				}
			}
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	private static void BFS(idx start) {
		Queue<idx> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			idx cur= q.poll();
			
			time = Math.max(cur.t, time);
			for(int i = 0 ; i < 4 ; i++) {
				int nr = dr[i] + cur.r;
				int nc = dc[i] + cur.c;
				
				if(nr >= 0 && nr < R && nc >=0 && nc <C && !visited[nr][nc]) {
					
				}
			}
		}
		
	}
}
