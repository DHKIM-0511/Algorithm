package gold2;

import java.io.*;
import java.util.*;

public class 청소년상어_19236 {
	//8방향 델타 배열
	static int[] dr = {-1,-1,0,1,1,1,0,-1}; 
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	static fish[][] map;
	static fish[] fish = new fish[17];
	static int ans = Integer.MIN_VALUE;
	static int eat = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new fish[4][4];
		for(int i = 0 ; i <4 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 4; j++) {
				int size = Integer.parseInt(st.nextToken()); // 물고기 크기
				int dir = Integer.parseInt(st.nextToken()); // 방향
				
				map[i][j] = new fish(i, j, size, dir);
				fish[size] = new fish(i, j, size, dir);
			}
		}
		DFS(new fish(0, 0, 0, 0),0);
//		System.out.println(ans);
	}
	private static void DFS(fish shark, int cnt) {
		// 언제 비교하고 끝냄
		if(check()) {
			ans = Math.max(ans, eat);
			return;
		}
		if(cnt == 0) { // 처음 상어가 들어갈때
			eat += map[0][0].size;
			shark.dir = map[0][0].dir;
			map[0][0] = shark;
		}else {
			for(int i = 0 ; i< 4 ; i ++) {
				int nr = shark.r + dr[shark.dir-1]+i;
				int nc = shark.c + dc[shark.dir-1]+i;
				
				if(nr<4 && nc<4) {
					setPosition();
					fish tmp = map[nr][nc];
					eat+=
					map[nr][nc].size = 0;
					DFS(new fish(nr, nc, 0, tmp.dir),cnt+1);
					map[nr][nc].size = tmp.size;
				}
			}
		}
	}
	private static boolean check() {
		
		return false;
	}
	private static void setPosition() { // 물고기 움직이기
		for(int i = 0 ; i < fish.length;i++) {
			fish cur = fish[i];
			for(int j = 0 ; j < 8 ; j++) { 
				int nr = cur.r + dr[(j+cur.dir-1)%8];
				int nc = cur.c + dc[(j+cur.dir-1)%8];
				
				if(nr>=0 && nr<4 && nc >=0 && nc<4 && map[nr][nc].size != 0) {
					fish tmp = map[cur.r][cur.c];
					tmp.dir =(j+cur.dir-1)%8;
					
					fish[i] = new fish(nr, nc, tmp.size, tmp.dir);
					fish[map[nr][nc].size] = new fish(cur.r, cur.c, map[nr][nc].size, map[nr][nc].dir);
					
					map[cur.r][cur.c] = map[nr][nc];
					map[nr][nc] = tmp;
					
					break;
				}
			}
		}
	}
	static class fish{
		int r,c,size,dir;
		public fish(int r, int c, int size, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dir = dir;
		}
	}
}
