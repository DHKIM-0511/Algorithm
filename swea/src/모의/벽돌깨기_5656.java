package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽돌깨기_5656 {
	static int N,W,H,ans;
	static int[][] map,copy;
	static boolean[][] visited ;
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			copy = new int[H][W];
			
			
			for(int i = 0 ; i < H ; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0 ; j < W ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = map[i][j];
				}
			}
			ans = Integer.MAX_VALUE;
			setPosition(0,new int[N]);
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void setPosition(int cnt ,  int[] sel) {
		if(cnt == N) {
			
			bomb(sel);
			
			int tmp = 0 ;
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					if(map[i][j] != 0) tmp++;
				}
			}
			
			ans = Math.min(ans,tmp);
			
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					map[i][j] = copy[i][j];
				}
			}
		}
		else {
			for(int i = 0 ; i< W ; i++) {
				sel[cnt] = i;
				setPosition(cnt+1 , sel);
			}
		}
	}
	private static void bomb(int[] sel) {
		for(int t = 0 ; t < N ; t++) {
			visited = new boolean[H][W];
			for(int i = 0 ; i < H ; i++) {
				
				if(map[i][sel[t]] > 0) {
					 int range = map[i][sel[t]] - 1;
					    map[i][sel[t]] = 0;
					    visited[i][sel[t]] = true;
					    
					for(int j = 1 ; j <= range ; j++) { // 폭발 범위
						
						int[] dr = {-j , j , 0 , 0 };
						int[] dc = {0 , 0 ,-j , j };
						
						for(int k = 0 ; k < 4 ; k++) {
							int nr = i + dr[k];
							int nc = sel[t] + dc[k];
							
							if(nr >=0 && nr < H && nc >= 0 && nc <W) {
								if(map[nr][nc] > 0 && !visited[nr][nc]) {
									bomb(nr,nc,map[nr][nc]);
									map[nr][nc] = 0;
								}
							}
						}
					}
					break;
				}
			}
			gravity();
		}
	}
	private static void bomb(int row, int col, int value) {
		if (visited[row][col] == true) return;
		visited[row][col] = true;
		for(int j = 1 ; j <= value-1 ; j++) { // 폭발 범위
			
			int[] dr = {-j , j , 0 , 0 };
			int[] dc = {0 , 0 ,-j , j };
			
			for(int k = 0 ; k < 4 ; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr >=0 && nr < H && nc >= 0 && nc <W) {
					if(map[nr][nc] > 0 && !visited[nr][nc]) {
						bomb(nr,nc,map[nr][nc]);
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
	//맵에 있는 요소들을 아래로 붙인다.
	private static void gravity() {
		Queue<Integer> tmp = new LinkedList<>();
		
		for(int i = 0 ; i < W ; i++) {
			for(int j = H - 1 ; j >= 0 ; j--) {
				if(map[j][i] != 0) {
					tmp.offer(map[j][i]);
					map[j][i]=0;
				}
			}
			for(int j = H - 1 ; j >= 0 ; j--) {
				if(!tmp.isEmpty()) map[j][i] =tmp.poll();
			}
		}
	}
}
