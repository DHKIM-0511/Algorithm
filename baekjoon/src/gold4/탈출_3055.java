package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {
	static int R,C,ans;
	static char[][] map;
	static idx start,end;
	static Queue<idx> floodArea;
	static int[] dr = {-1,1,0,0} ,dc= {0,0,-1,1};
	static class idx{
		int r,c,time;
		public idx(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		
		map = new char[R][C];
		floodArea = new LinkedList<>();
		
		for(int i = 0 ; i < R ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'S') {
					start = new idx(i, j, 0);
					map[i][j] ='.';
				}
				else if(map[i][j] =='D') end = new idx(i, j, 0);
			}
		}
		BFS();
		if(ans == 0) System.out.println("KAKTUS");
		else System.out.println(ans);
	}
	private static void BFS() {
		boolean[][] visited= new boolean[R][C];
		boolean[][] riverVisited= new boolean[R][C];
		Queue<idx> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			// 물 추가
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					if(map[i][j] =='*') floodArea.add(new idx(i, j, 0));
				}
			}
			//물을 먼저 이동
			while(!floodArea.isEmpty()) {
				idx w = floodArea.poll();
				
				for(int i = 0 ; i < 4; i++) {
					int nr = w.r + dr[i];
					int nc = w.c + dc[i];
					
					if(nr >=0 && nr < R && nc >=0 && nc < C  && ! riverVisited[nr][nc]) {
						if(map[nr][nc] =='.') {
							map[nr][nc] ='*';
							riverVisited[nr][nc] = true;
						}
					}
				}
			}
			int n = q.size();
			
			//고슴 도치 이동
			for(int t = 0 ; t < n ; t++) {
				
				idx cur = q.poll();
				if(cur.r == end.r && cur.c == end.c) {
					ans = cur.time;
					break;
				}
				for(int i = 0 ; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if(nr >=0 && nr < R && nc >=0 && nc < C && !visited[nr][nc]) {
						if(map[nr][nc] =='.' ||map[nr][nc]=='D') {
							q.add(new idx(nr, nc, cur.time+1));
							visited[nr][nc]=true;
						}
					}
				}
			}
		}
	}
}



















