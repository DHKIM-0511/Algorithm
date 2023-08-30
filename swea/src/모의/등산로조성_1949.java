package 모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 등산로조성_1949 {
	static int N,K,ans;
	static int[][][] map;
	static boolean[][][] visited;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class idx{
		int r,c,len,cnt,times;
		public idx(int r, int c, int len, int cnt, int times) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
			this.cnt = cnt;
			this.times = times;
		}
		@Override
		public String toString() {
			return "idx [r=" + r + ", c=" + c + ", len=" + len + ", cnt=" + cnt + ", times=" + times + "]";
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <=t ;tc++) {
			st = new StringTokenizer(br.readLine());
			
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			
			map = new int[K+1][N][N];
			
			int tmp = Integer.MIN_VALUE;
			for(int k =0 ; k <= K ; k++) {
				for(int i = 0 ; i < N ; i ++) {
					if(k==0)
					st= new StringTokenizer(br.readLine());
					for(int j = 0 ; j < N ;j++) {
						if(k==0) {
						map[0][i][j] = Integer.parseInt(st.nextToken());
						tmp = Math.max(map[0][i][j], tmp); // 제일 높은 지형의 높이
						}
						else {
							map[k][i][j] =map[0][i][j];
						}
					}
				}
			}
			
			ans = 0;
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ; j< N ; j++) {
					if(map[0][i][j] == tmp) {
						DFS(new idx(i, j,0,0,0));
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void DFS(idx start) {
		visited = new boolean[K+1][N][N];
		Stack<idx> stack = new Stack<>();
		
		stack.add(start);
		visited[0][start.r][start.c] = true;
		
		while(!stack.isEmpty()) {
			idx cur = stack.pop();
			
			map[cur.cnt][cur.r][cur.c] -= cur.cnt;
			
			System.out.println(cur.toString());
			for(int[] a: map[cur.cnt]) {
				System.out.println(Arrays.toString(a));
			}
			
			for(int i = 0 ; i< 4 ; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(map[cur.cnt][cur.r][cur.c] > map[cur.cnt][nr][nc]-K) {
						
						if(cur.times == 0) { // 공사 가능 줄일 수 있는 높이만큼 하나씩 전부 고려
							for(int j = 1 ; j <= K ;j++) { 
								if(!visited[cur.cnt+j][nr][nc]) {
									stack.add(new idx(nr, nc, cur.len+1, cur.cnt+j, cur.times+1));
									visited[cur.cnt+j][nr][nc] = true;
								}
							}
						} 
						//가능이던 불가능이던 그냥 진행하는 경우
						if(map[cur.cnt][cur.r][cur.c] > map[cur.cnt][nr][nc]) {
							if(!visited[cur.cnt][nr][nc]) {
								stack.add(new idx(nr, nc, cur.len+1, cur.cnt, cur.times));
								visited[cur.cnt][nr][nc] = true;
							}
						}else {
							
						}
						
					}else {
						ans = Math.max(ans, cur.len);
					}
				}
			}
			map[cur.cnt][cur.r][cur.c] += cur.cnt;
		}
	}
}



























