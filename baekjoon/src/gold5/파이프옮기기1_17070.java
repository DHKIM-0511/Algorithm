package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 파이프옮기기1_17070 {
	static int n;
	static int[][] map;
	
	public static class idx{
		int r,c;
		int mode;
		
		public idx(int r, int c,int mode) {
			super();
			this.r = r;
			this.c = c;
			this.mode = mode;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Stack<idx> stack = new Stack<>();
		stack.add(new idx(0, 1 , 0));
		int ans= 0;
		
		while(!stack.isEmpty()) {
			idx cur = stack.pop();
			
			if(cur.r == n-1 && cur.c == n-1) {
				ans++;
				continue;
			}

			if(cur.mode == 0) {
				if( isIn(cur.r , cur.c+1) && map[cur.r][cur.c+1] != 1 ) 
					stack.push(new idx(cur.r , cur.c +1,0));
				
				if(isIn(cur.r+1 , cur.c+1)) {
					if(map[cur.r][cur.c+1] !=1 && map[cur.r+1][cur.c] != 1&& map[cur.r+1][cur.c+1] != 1)
						stack.push(new idx(cur.r+1 , cur.c +1,1));
				}
			}else if(cur.mode == 1) {
				if(isIn(cur.r , cur.c+1) && map[cur.r][cur.c+1] != 1 ) 
					stack.push(new idx(cur.r , cur.c +1,0));
				
				if(isIn(cur.r+1 , cur.c+1)) {
					if(map[cur.r][cur.c+1] !=1 && map[cur.r+1][cur.c] != 1&& map[cur.r+1][cur.c+1] != 1)
						stack.push(new idx(cur.r+1 , cur.c +1,1));
				}
				
				if(isIn(cur.r+1 , cur.c) && map[cur.r+1][cur.c] != 1) 
					stack.push(new idx(cur.r+1 , cur.c,2));
			}else {
				
				if(isIn(cur.r+1 , cur.c+1)) {
					if(map[cur.r][cur.c+1] !=1 && map[cur.r+1][cur.c] != 1&& map[cur.r+1][cur.c+1] != 1)
						stack.push(new idx(cur.r+1 , cur.c +1,1));
				}
				
				if(isIn(cur.r+1 , cur.c) && map[cur.r+1][cur.c] != 1 ) 
					stack.push(new idx(cur.r+1 , cur.c,2));
			}
		}
		System.out.println(ans);
	}
	static boolean isIn(int r , int c) {
		if(r < n && r >=0 && c < n && c >=0) return true;
		else return false;
	}
}
