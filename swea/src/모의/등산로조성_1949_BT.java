package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등산로조성_1949_BT {
	static int N,K,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <=t ;tc++) {
			st = new StringTokenizer(br.readLine());
			
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			int tmp = Integer.MIN_VALUE;
			
			for(int i = 0 ; i < N ; i ++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmp = Math.max(map[i][j], tmp); // 제일 높은 지형의 높이
				}
			}
			ans = 0;
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ; j< N ; j++) {
					if(map[i][j] == tmp) {
						DFS(i,j,1,true);
//						DFS2(i,j,map[i][j],1,true);
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void DFS(int r, int c , int dist , boolean skill) {
		if(dist > ans) {
			ans = dist;
		}
		visited[r][c] = true; // 해당 지점 방문
		for(int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			//가장먼저 가지치기
			if(nr>=0 && nr <N && nc >=0 && nc <N && !visited[nr][nc]) {
				//1. 공사 안하고 가기
				if(map[r][c] > map[nr][nc]) DFS(nr, nc, dist+1, skill);
				//2. 공사해야하는데 공사 안했다면
				else if(skill && map[r][c] > map[nr][nc]-K) {
					int tmp = map[nr][nc];
					map[nr][nc] = map[r][c]-1;
					DFS(nr, nc, dist+1, false);
					map[nr][nc] = tmp;
				}
			}
		}
		visited[r][c] = false;
	}
	
	private static void DFS2(int r, int c ,int h, int dist , boolean skill) {
		if(dist > ans) {
			ans = dist;
		}
		visited[r][c] = true; // 해당 지점 방문
		for(int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			//가장먼저 가지치기
			if(nr>=0 && nr <N && nc >=0 && nc <N && !visited[nr][nc]) {
				//1. 공사 안하고 가기
				if(h > map[nr][nc]) DFS2(nr, nc,map[nr][nc], dist+1, skill);
				//2. 공사해야하는데 공사 안했다면
				else if(skill && h > map[nr][nc]-K) DFS2(nr, nc,map[nr][nc]-1, dist+1, false);
				
			}
		}
		visited[r][c] = false;
	}
}



























