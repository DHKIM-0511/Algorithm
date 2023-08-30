package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {
	static int n, m, ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] map;
	static class idx {
		int r;
		int c;
		int time;
		public idx(int x, int y, int time) {
			this.r = x;
			this.c = y;
			this.time = time;
		}
	}
	public static Queue<idx> jh, fire;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		jh = new LinkedList<>();
		fire = new LinkedList<>();
		map = new char[n][m];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(map[i][j] == 'J') {
					jh.add(new idx(i, j, 0));
				}
				if(map[i][j] == 'F') {
					fire.add(new idx(i, j, 0));
				}
			}
		}
		
		ans = 0;
		if(bfs()) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	}
	public static boolean bfs() {
		while(!jh.isEmpty()) {
			// 불 먼저
			int f_size = fire.size();
			for(int i=0;i<f_size;i++) {
				idx cur = fire.poll();
				
				for(int d=0;d<4;d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if(0 <= nr && nr < n && 0 <= nc && nc < m ) {
						if(map[nr][nc] != '#' && map[nr][nc] !='F') {
							map[nr][nc] = 'F';
							fire.add(new idx(nr, nc, cur.time+1));
						}
					} 
				}
			}
			int j_size = jh.size();
			
			for(int i=0;i<j_size;i++) {
				idx cur = jh.poll();
				
				for(int d=0;d<4;d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
						ans = cur.time+1;
						return false;
					}
					
					if(map[nr][nc] != '#' && map[nr][nc] !='F' && map[nr][nc] != 'J' ) {
						jh.add(new idx(nr, nc, cur.time+1)); 
						map[nr][nc] = 'J';
					}
				}
			}
		}
		return true;
	}
}