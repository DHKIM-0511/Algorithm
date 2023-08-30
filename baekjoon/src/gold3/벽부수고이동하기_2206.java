package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {
	static int N,M,ans;
	static int[][] map;
	static int[] dr = {-1, 1 , 0 , 0 };
	static int[] dc = { 0, 0 , -1 , 1 };
	
	static class idx{
		int r ,c ,cnt;
		int destroy;
		public idx(int r, int c, int cnt, int destroy) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.destroy = destroy;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		ans = Integer.MAX_VALUE;
		BFS();
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void BFS() {
		boolean[][][] visited = new boolean[2][N][M];
		Queue<idx> q = new LinkedList<>();
		q.add(new idx(0,0,1,0)); // destroy = 0 = > 아직 안부숨
		visited[0][0][0]= true;
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			if(cur.r == N-1 && cur.c ==M-1) {
				ans = Math.min(ans, cur.cnt);
				break;
			}
			
			for(int i = 0 ; i< 4; i++) {
				int nr =cur.r + dr[i];
				int nc =cur.c + dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(map[nr][nc] == 0) {
						if(!visited[cur.destroy][nr][nc]) {
							visited[cur.destroy][nr][nc] = true;
							q.add(new idx(nr, nc, cur.cnt+1, cur.destroy));
						}
					}else {
						if(cur.destroy==0 && !visited[cur.destroy+1][nr][nc]) {
							visited[cur.destroy+1][nr][nc] = true;
							q.add(new idx(nr, nc, cur.cnt+1, cur.destroy+1));
						}
					}
				}
			}
		}
	}
}
