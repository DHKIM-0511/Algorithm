package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
	static int N,M , r, c , d , ans;
	static int[][] map  ;
	static boolean[][] visited;
	
	static class idx{
		int r , c , mode;

		public idx(int r, int c,int mode) {
			super();
			this.r = r;
			this.c = c;
			this.mode = mode;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 0 = 북 , 1 = 동 , 2 = 남 , 3 = 서
		
		map = new int[N][M]; // 0 = 청소 x , 1 = 벽
		visited = new boolean[N][M]; 
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans =0;
		DFS();
		System.out.println(ans);
	}
	private static void DFS() {
		Stack<idx> stack = new Stack<>();
		stack.push(new idx(r, c, d));
		
		while(!stack.isEmpty()){
			idx cur = stack.pop();
			
//			if(visited[cur.r][cur.c]) continue;
//			visited[cur.r][cur.c] = true;
			
			if(map[cur.r][cur.c] == 0) {
				ans++;
			}
			
			if(isClean(cur.r , cur.c)) { // 주변에 청소할 칸이 없는 경우
				if(cur.mode == 0) {
					if(isIn(cur.r+1 , cur.c))
						stack.push(new idx(cur.r + 1, cur.c, cur.mode));
				}
				else if(cur.mode == 1) {
					if(isIn(cur.r , cur.c-1))
					stack.push(new idx(cur.r , cur.c - 1, cur.mode));
				}
				else if(cur.mode == 2) {
					if(isIn(cur.r-1 , cur.c))
					stack.push(new idx(cur.r - 1, cur.c, cur.mode));
				}
				else {
					if(isIn(cur.r , cur.c+1))
					stack.push(new idx(cur.r, cur.c + 1, cur.mode));
				}
			}else { // 청소할 칸이 있는 경우
				
				// 0 = 북 , 1 = 동 , 2 = 남 , 3 = 서
				
				if(cur.mode == 0) {
					if(isIn(cur.r , cur.c - 1) && map[cur.r][cur.c-1] == 0)
						stack.push(new idx(cur.r, cur.c-1, 3));
				}
				else if(cur.mode == 1) {
					if(isIn(cur.r-1 , cur.c) && map[cur.r-1][cur.c-1] == 0)
					stack.push(new idx(cur.r-1 , cur.c, 0));
				}
				else if(cur.mode == 2) {
					if(isIn(cur.r , cur.c+1) && map[cur.r][cur.c+1] == 0)
					stack.push(new idx(cur.r, cur.c+1, 1));
				}
				else {
					if(isIn(cur.r+1 , cur.c) && map[cur.r+1][cur.c] == 0)
					stack.push(new idx(cur.r+1, cur.c + 1, 2));
				}
			}
		}
	}
	private static boolean isIn(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < M) return true;
		else return false;
	}
	private static boolean isClean(int x, int y) {
		if(isIn(x+1 , y +1) && isIn(x-1,y-1)) {
			if(map[x+1][y] != 0 & map[x-1][y] != 0 & map[x][y+1] != 0 & map[x][y-1] != 0) return true;
			else return false;
		}
		else return false;
	}
}
