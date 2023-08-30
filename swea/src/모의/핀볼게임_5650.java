package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 핀볼게임_5650 {
	static class idx{
		int r,c,mode;

		public idx(int r, int c, int mode) {
			super();
			this.r = r;
			this.c = c;
			this.mode = mode;
		}

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "idx [r=" + r + ", c=" + c + ", mode=" + mode + "]";
		}
	}
	static int n,ans;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t ; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			
			map = new int[n+2][n+2];
			
			
			for(int i = 0 ; i < n+2 ; i++) {
				map[0][i] = map[i][0] = map[n+1][i] = map[i][n+1] = 5;
				if(i >= 1 && i <= n) {
					st = new StringTokenizer(br.readLine());
					for(int j = 1 ; j < n+1 ; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			ans =Integer.MIN_VALUE;
			start();
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void start() { // 1~n 범위로 움직인다.
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j = 1 ; j < n+1 ; j++) {
				if(map[i][j] == 0) {
					DFS(i,j);
				}
			}
		}
	}
	private static void DFS(int i, int j) {
		
		
		for(int t = 1 ; t <= 4 ; t++) { // 1. 상 , 2. 하 , 3. 좌 , 4 . 우
			Stack<idx> stack = new Stack<>();
			stack.push(new idx(i, j,t));
			int cnt = 0;
			boolean flag= false;
			
			out:while(!stack.isEmpty()) {
				idx cur = stack.pop();
//				System.out.println("t"+t+cur.toString());
//				System.out.println("i:"+i +"j:"+j);
				
				if(flag && cur.r==i && cur.c==j) {
					break;
				}
				if(cur.r==i && cur.c==j)flag=true;
				
				
				switch (cur.mode) {
				case 1:
					idx next1 = new idx(cur.r-1, cur.c, cur.mode);
					
					if(map[next1.r][next1.c] == -1 || next1.r == i && next1.c == j) {
						break out;
					}else if(map[next1.r][next1.c] == 1 || map[next1.r][next1.c] == 4 || map[next1.r][next1.c] == 5) {
						cnt=cnt*2+1;
						break out;
					}else if(map[next1.r][next1.c] == 2) {
						stack.push(new idx(cur.r-1, cur.c , 4));
						cnt++;
						continue;
					}else if(map[next1.r][next1.c] == 3) {
						stack.push(new idx(cur.r-1, cur.c , 3));
						cnt++;
						continue;
					}else if(map[next1.r][next1.c] == 0) {
						stack.push(next1);
						continue;
					}else {
						stack.push(wormHole(next1));
					}
					break;
				case 2:
					idx next2 = new idx(cur.r+1, cur.c, cur.mode);
					
					if(map[next2.r][next2.c] == -1 || next2.r == i && next2.c == j) {
						break out;
					}else if(map[next2.r][next2.c] == 1) {
						stack.push(new idx(cur.r+1, cur.c , 4));
						cnt++;
						continue;
					}else if(map[next2.r][next2.c] == 2 || map[next2.r][next2.c] ==3 || map[next2.r][next2.c] ==5) {
						cnt=cnt*2+1;
						break out;
					}else if(map[next2.r][next2.c] == 4) {
						stack.push(new idx(cur.r+1, cur.c , 3));
						cnt++;
						continue;
					}else if(map[next2.r][next2.c] == 0) {
						stack.push(next2);
						continue;
					}else {
						stack.push(wormHole(next2));
					}
					break;
				case 3:
					idx next3 = new idx(cur.r, cur.c-1, cur.mode);
					
					if(map[next3.r][next3.c] == -1 || next3.r == i && next3.c == j) {
						break out;
					}else if(map[next3.r][next3.c] == 1) {
						stack.push(new idx(cur.r, cur.c-1 , 1));
						cnt++;
						continue;
					}else if(map[next3.r][next3.c] == 2) {
						stack.push(new idx(cur.r, cur.c-1 , 2));
						cnt++;
						continue;
					}else if(map[next3.r][next3.c] == 3 ||map[next3.r][next3.c] ==4 || map[next3.r][next3.c] ==5) {
						cnt=cnt*2+1;
						break out;
					}else if(map[next3.r][next3.c] == 0) {
						stack.push(next3);
						continue;
					}else {
						stack.push(wormHole(next3));
					}
					break;
				case 4:
					idx next4 = new idx(cur.r, cur.c+1, cur.mode);
					
					if(map[next4.r][next4.c] == -1 || next4.r == i && next4.c == j) {
						break out;
					}else if(map[next4.r][next4.c] == 1 || map[next4.r][next4.c] ==2 || map[next4.r][next4.c] ==5) {
						cnt=cnt*2+1;
						break out;
					}else if(map[next4.r][next4.c] == 3) {
						stack.push(new idx(cur.r, cur.c+1 , 2));
						cnt++;
						continue;
					}else if(map[next4.r][next4.c] == 4) {
						stack.push(new idx(cur.r, cur.c+1 , 1));
						cnt++;
						continue;
					}else if(map[next4.r][next4.c] == 0) {
						stack.push(next4);
						continue;
					}else {
						stack.push(wormHole(next4));
					}
					break;
				default:
					break;
				}
				
			}
			ans = Math.max(ans, cnt);
		}
		
	}
	private static idx wormHole(idx cur) {
		for(int i = 1 ; i < n+1 ; i++) {
			for(int j = 1; j <n+1 ; j++) {
				if((i != cur.r || j != cur.c) && map[cur.r][cur.c] == map[i][j])
					return new idx(i, j, cur.mode);
			}
		}
		return cur;
	}
}
