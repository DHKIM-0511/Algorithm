package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역_2468 {
	static int N,ans,maxH;
	static int[][] map;
	static int[] dr = {-1,1,0,0} , dc = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		maxH = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(map[i][j], maxH);
			}
		}
		ans=1;
		for(int i = 1 ; i < maxH ; i++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					if(map[j][k] > i && !visited[j][k]) {
						BFS(new idx(j, k),i);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	private static void BFS(idx start,int rain) {
		Queue<idx> q = new LinkedList<>();
		visited[start.r][start.c] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			idx cur = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 &&nc < N && !visited[nr][nc]) {
					if(map[nr][nc] > rain) {
						visited[nr][nc] = true;
						q.add(new idx(nr, nc));
					}
				}
			}
		}
	}
	static class idx{
		int r, c;
		public idx(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "idx [r=" + r + ", c=" + c + "]";
		}
	}
}
