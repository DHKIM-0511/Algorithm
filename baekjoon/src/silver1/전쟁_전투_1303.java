package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전쟁_전투_1303 {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	static class idx{
		int r,c;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visited= new boolean[m][n];
		
		for(int i = 0 ; i < m ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		int W = 0;
		int B = 0;
		for(int i = 0 ;i  < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(!visited[i][j]) {
					if(map[i][j] == 'W') {
						W+= (int)Math.pow(BFS(new idx(i, j)), 2);
					}else {
						B+= (int)Math.pow(BFS(new idx(i, j)), 2);
					}
				}
			}
		}
		System.out.println(W+" "+B);
	}
	private static int BFS(idx start) {
		Queue<idx> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			cnt++;
			for(int i = 0 ; i <4 ; i++) {
				
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >=0 && nr < m && nc >=0 && nc <n && !visited[nr][nc]) {
					if(map[cur.r][cur.c] == map[nr][nc]) {
						q.add(new idx(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
		}
		return cnt;
	}
}
