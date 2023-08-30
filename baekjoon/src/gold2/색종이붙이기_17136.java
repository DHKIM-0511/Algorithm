package gold2;

import java.io.*;
import java.util.*;

public class 색종이붙이기_17136 {
	static int ans;
	static int[][] map;
	static int[] paperCnt = {0,5,5,5,5,5};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		for(int i = 0 ; i <10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< 10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		DFS(new idx(0, 0),0);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void DFS(idx cur , int cnt) {
		if(cur.r >= 9 && cur.c>9) { // 맨 끝점 도달시 종료
			ans = Math.min(ans, cnt);
			return;
		}
		if(ans <= cnt) return; // 최소값보다 커지면 종료
		// 행 이동
		if(cur.c > 9) { 
			DFS(new idx(cur.r+1, 0),cnt);
			return;
		}
		
		if(map[cur.r][cur.c] == 1) {
			for(int i = 5 ; i >= 1 ; i--) {
				//색종이가 남았고 해당 사이즈를 붙일 수 있으면
				if(paperCnt[i] > 0 && check(new idx(cur.r, cur.c),i)) {
					attach(new idx(cur.r,cur.c ), i ,0);
					paperCnt[i]--;
					DFS(new idx(cur.r, cur.c+1),cnt+1);
					attach(new idx(cur.r,cur.c ), i ,1);
					paperCnt[i]++;
				}
			}
		}
		else DFS(new idx(cur.r, cur.c+1),cnt);
	}
	private static void attach(idx idx, int size, int state) {
		for(int i = idx.r ; i < idx.r+size ; i++) {
			for(int j = idx.c ; j < idx.c+size ; j++) {
				 map[i][j] = state;
			}
		}
	}
	private static boolean check(idx idx, int size) {
		for(int i = idx.r ; i < idx.r+size ; i++) {
			for(int j = idx.c ; j < idx.c+size ; j++) {
				//경계조건
				if(i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				if(map[i][j] != 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	static class idx{
		int r,c;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
