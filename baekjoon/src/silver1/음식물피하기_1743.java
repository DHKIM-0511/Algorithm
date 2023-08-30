package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 음식물피하기_1743 {
	static int N,M,K,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1 , 0, 0} , dc = { 0 , 0, -1 , 1};
	static class idx{
		int r,c;

		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}
		ans = 0;
		for(int i = 0 ; i< N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 1) { 
					visited[i][j] = true;
					DFS(new idx(i, j));
				}
			}
		}
		System.out.println(ans);
	}
	private static void DFS(idx start) {
		int size=0;
		Stack<idx> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			idx cur = stack.pop();
			size++;
			ans = Math.max(size, ans);
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r+dr[i];
				int nc = cur.c+dc[i];
				
				if(nr>= 0 && nr < N && nc >=0 && nc < M && !visited[nr][nc]) {
					if(map[nr][nc] == 1) {
						visited[nr][nc] = true;
						stack.push(new idx(nr, nc));
					}
				}
			}
		}
	}
}