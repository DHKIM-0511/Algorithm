package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
	static int M,N,K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1 , 1 , 0 , 0};
	static int[] dc = { 0 , 0 , -1 , 1};
	static class idx{
		int r,c;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map= new int[N][M];
			visited= new boolean[N][M];
			
			for(int i = 0 ; i < K ; i++) {
				st=new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			int ans=0;
			for(int i = 0 ; i< N ; i++) {
				for(int j = 0 ; j< M ; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						find(i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	private static void find(int si, int sj) {
		Stack<idx> stack = new Stack<>();
		visited[si][sj]=true;
		stack.push(new idx(si, sj));
		
		while(!stack.isEmpty()) {
			idx cur = stack.pop();
			
			for(int i = 0 ; i< 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >=0 && nr <N && nc >=0 && nc <M) {
					if(map[nr][nc]==1&&!visited[nr][nc]) {
						visited[nr][nc] = true;
						stack.push(new idx(nr, nc));
						
					}
				}
			}
		}
	}
}
