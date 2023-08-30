package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페 {
	static int n , ans;
	static int[][] map;
	static boolean[] visited = new boolean[101];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			DFS(0 , 0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void DFS(int r, int c) {
		//4방으로 갈 수 있는지 판별..
		if(checkLeftUp(r,c)) {
			
		}else if(checkLeftDw(r, c)) {
			
		}else if(checkRightDw(r, c)) {
			
		}else if(checkRightUp(r, c)) {
			
		}
		
		
	}
	private static boolean checkLeftUp(int r ,int c) {
		int distance = 0;
		int copyR = r;
		int copyC = c;
		visited[map[r][c]] = true;
		while(true) {
			int nr = copyR-1;
			int nc = copyC-1;
			
			if(copyR < n && copyC < n && copyR >= 0 && copyC >= 0 && !visited[map[nr][nc]]) {
				distance++;
				visited[map[nr][nc]] = true;
			}else if(copyR == n || copyC == n || copyR < 0 || copyC < 0 && visited[map[nr][nc]]) {
				break;
			}
		}
		if(distance >= 1) {
			if(copyR == 0 && copyC == 0) {
				return false;
			}else return true;
		}else return false;
		
	}
	private static boolean checkLeftDw(int r ,int c) {
		int distance = 0;
		int copyR = r;
		int copyC = c;
		visited[map[r][c]] = true;
		while(true) {
			int nr = copyR+1;
			int nc = copyC-1;
			
			if(copyR < n && copyC < n && copyR >= 0 && copyC >= 0 && !visited[map[nr][nc]]) {
				distance++;
				visited[map[nr][nc]] = true;
			}else if(copyR == n || copyC == n || copyR < 0 || copyC < 0 && visited[map[nr][nc]]) {
				break;
			}
		}
		if(distance >= 1) {
			if(copyR == n-1 && copyC == 0) {
				return false;
			}else return true;
		}else return false;
	}
	private static boolean checkRightDw(int r ,int c) {
		int distance = 0;
		int copyR = r;
		int copyC = c;
		visited[map[r][c]] = true;
		while(true) {
			int nr = copyR+1;
			int nc = copyC+1;
			
			if(copyR < n && copyC < n && copyR >= 0 && copyC >= 0 && !visited[map[nr][nc]]) {
				distance++;
				visited[map[nr][nc]] = true;
			}else if(copyR == n || copyC == n || copyR < 0 || copyC < 0 && visited[map[nr][nc]]) {
				break;
			}
		}
		if(distance >= 1) {
			if(copyC == n-1 && copyR == n-1) {
				return false;
			}else return true;
		}else return false;
	}
	private static boolean checkRightUp(int r ,int c) {
		int distance = 0;
		int copyR = r;
		int copyC = c;
		visited[map[r][c]] = true;
		while(true) {
			int nr = copyR-1;
			int nc = copyC+1;
			visited[map[nr][nc]] = true;
			if(copyR < n && copyC < n && copyR >= 0 && copyC >= 0 && !visited[map[nr][nc]]) {
				distance++;
				visited[map[nr][nc]] = true;
			}else if(copyR == n || copyC == n || copyR < 0 || copyC < 0 && visited[map[nr][nc]]) {
				break;
			}
		}
		if(distance >= 1) {
			if(copyC == n-1 && copyR == 0) {
				return false;
			}else return true;
		}else return false;
	}
}
