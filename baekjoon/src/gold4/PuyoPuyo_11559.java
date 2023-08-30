package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PuyoPuyo_11559 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0},dc= {0,0,-1,1};
	static boolean check;
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
		
		map = new char[12][6];
		
		for(int i = 0 ; i < 12 ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j< 6 ; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		int cnt = 0;
		while (true) {
			check = false;
			BFS();
			if (!check) break;
			gravity();
			cnt++;
		}
		
		System.out.println(cnt);
	}
	private static void BFS() {
		visited = new boolean[12][6];
		Queue<idx> q = new LinkedList<>();
		
		for(int i = 0 ; i< 12 ; i++) {
			for(int j = 0 ; j< 6 ; j++) {
				
				if(!visited[i][j] && map[i][j] != '.') {
					ArrayList<idx> puyo = new ArrayList<>();
					q.add(new idx(i, j));
					puyo.add(new idx(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						idx cur = q.poll();
						
						for(int k = 0 ; k < 4 ; k++) {
							int nr = cur.r + dr[k];
							int nc = cur.c + dc[k];
							
							if(nr >= 0 && nr < 12 && nc >= 0 && nc <6 && !visited[nr][nc]) {
								if(map[cur.r][cur.c] == map[nr][nc]) {
									q.add(new idx(nr, nc));
									puyo.add(new idx(nr, nc));
									visited[nr][nc] = true;
								}
							}
						}
					}
					if(puyo.size() >= 4) {
						check = true;
						for(idx tmp : puyo) {
							map[tmp.r][tmp.c] ='.';
						}
					}
				}
			}
		}
	}
	private static void gravity() {
		Queue<Character> color = new LinkedList<>();
 		for(int i = 0 ; i < 6 ; i++) {
			for(int j = 11 ; j >= 0 ; j--) {
				if(map[j][i] != '.') {
					color.add(map[j][i]);
					map[j][i] ='.';
				}
			}
			
			for(int j = 11 ; j >= 0 ; j--) {
				if(color.size() > 0) {
					map[j][i] =color.poll();
				}else break;
			}
		}
	}
}



























