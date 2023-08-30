package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569_1 {
	static int n,m,h;
	
	
	//익은 토마토의 위치.
	public static class dot {
		int x;
		int y;
		int h;
		
		public dot(int x, int y,int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[h][n][m];
		
		Queue<dot> dq = new LinkedList<>();
		
		boolean check = false;
		
		for(int hh=0; hh<h; hh++) {
			for(int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < m ; j++) {
					map[hh][i][j] = Integer.parseInt(st.nextToken());
					if(map[hh][i][j] == 1) {
						dot d = new dot(i, j,hh);
						dq.add(d); // 시작위치를 q 에 넣는다
					}
					if(map[hh][i][j] == 0) { 
						check =  true;
					}
				}
			}
		}
		
		// 0 이 없으면 0출력후 종료
		if(!check) {
			System.out.println(0);
			return;
		}
		// 0 이 있으면 bfs함수 실행
		bfs(dq , map);
		int max = 0;
		for(int hh = 0 ; hh < h ; hh++) {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j< m ; j++) {
				if(map[hh][i][j] > max ) max = map[hh][i][j]; // 최대값 저장
				if(map[hh][i][j] == 0) {
					System.out.println(-1);
					return;		
				}
			}
		}
		}
		System.out.println(max - 1); // 아니면 max - 1
	}

	public static void bfs(Queue<dot> dq, int[][][] map) {
		int[] dr = {-1 , 1 , 0 , 0,0,0 };
		int[] dc = { 0 , 0, -1 , 1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		while(!dq.isEmpty()) {
			dot tmp = dq.poll();
		
			for(int i = 0 ; i < 6 ; i++) {
				int nr = tmp.x + dr[i];
				int nc = tmp.y + dc[i];
				int nz = tmp.h + dz[i];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && nz >= 0 && nz < h) {
					if(map[nz][nr][nc]==0) {
						map[nz][nr][nc] = map[tmp.h][tmp.x][tmp.y] + 1;
						dot d = new dot(nr , nc , nz);
						dq.offer(d);
					}
				}
			}
			for(int[][] a : map) {
            	for(int[] b : a)
            	System.out.println(Arrays.toString(b));
            }
            System.out.println("-------------------------------");
		}
	}
}
